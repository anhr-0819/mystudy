package bitcamp.myapp.servlet;

import bitcamp.myapp.controller.AssignmentController;
import bitcamp.myapp.controller.AuthController;
import bitcamp.myapp.controller.BoardController;
import bitcamp.myapp.controller.HomeController;
import bitcamp.myapp.controller.MemberController;
import bitcamp.myapp.controller.RequestMapping;
import bitcamp.myapp.controller.RequestParam;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

  private Map<String, RequestHandler> requestHandlerMap = new HashMap<>();
  private List<Object> controllers = new ArrayList<>();

  @Override
  public void init() throws ServletException {
    ServletContext ctx = this.getServletContext();
    BoardDao boardDao = (BoardDao) ctx.getAttribute("boardDao");
    MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
    AssignmentDao assignmentDao = (AssignmentDao) ctx.getAttribute("assignmentDao");
    AttachedFileDao attachedFileDao = (AttachedFileDao) ctx.getAttribute("attachedFileDao");
    TransactionManager txManager = (TransactionManager) ctx.getAttribute("txManager");

    controllers.add(new HomeController());
    controllers.add(new AssignmentController(assignmentDao));
    controllers.add(new AuthController(memberDao));

    String boardUploadDir = this.getServletContext().getRealPath("/upload/board");
    controllers.add(new BoardController(txManager, boardDao, attachedFileDao, boardUploadDir));

    String memberUploadDir = this.getServletContext().getRealPath("/upload");
    controllers.add(new MemberController(memberDao, memberUploadDir));

    prepareRequestHandlers(controllers);

  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      // URL 요청을 처리할 request handler를 찾는다.
      RequestHandler requestHandler = requestHandlerMap.get(request.getPathInfo());
      if (requestHandler == null) {
        throw new Exception(request.getPathInfo() + " 요청 페이지를 찾을 수 없습니다.");
      }

      Object[] args = prepareRequestHandlerArguments(requestHandler.handler, request, response);

      String viewUrl = (String) requestHandler.handler.invoke(requestHandler.controller, args);
      // invoke(인스턴스주소,메서드에 넘겨줄 값) <- 주어진 메서드 정보를 가지고 해당 클래스에서 메서드를 호출하는 역할을 한다.
      // 메서드를 호출할때는 인스턴스 주소가 필요하므로 전달한다.

      // 페이지 컨트롤러가 알려준 JSP로 포워딩 한다.
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        request.getRequestDispatcher(viewUrl).forward(request, response);
      }

    } catch (Exception e) {
      // 페이지 컨트롤러에서 오류가 발생했으면 오류페이지로 포워딩한다.
      request.setAttribute("message", request.getPathInfo() + " 실행 오류!");

      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      request.setAttribute("detail", stringWriter.toString());

      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }

  private void prepareRequestHandlers(
      List<Object> controllers) { // 컨트롤러 배열에서 하나의 컨트롤러를 꺼내서 클래스 정보로 메소드 목록을 알아내어, 애노테이션이 붙은 메서드를 찾아서 컨트롤러 객체와 함께 보관한다.
    for (Object controller : controllers) {
      Method[] methods = controller.getClass().getDeclaredMethods();
      for (Method m : methods) {
        RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
        if (requestMapping != null) {
          requestHandlerMap.put(requestMapping.value(), new RequestHandler(controller, m));
        }
      }
    }
  }

  private Object[] prepareRequestHandlerArguments(
      Method handler,
      HttpServletRequest request,
      HttpServletResponse response) {

    // 요청 핸들러의 파라미터 정보를 알아낸다.
    Parameter[] params = handler.getParameters();

    // 파라미터에 전달할 값을 담을 배열을 준비한다.
    Object[] args = new Object[params.length]; // 전달할 값을 배열에 담아 가변 파라미터 자리에 넘겨줄 수 있다.

    // 파라미터를 분석하여 각 파라미터에 맞는 값을 배열에 담는다.
    for (int i = 0; i < args.length; i++) {
      Parameter param = params[i];
      if (param.getType() == HttpServletRequest.class
          || param.getType() == ServletRequest.class) {
        args[i] = request;
      } else if (param.getType() == HttpServletResponse.class
          || param.getType() == ServletResponse.class) {
        args[i] = response;
      } else {
        RequestParam requestParam = param.getAnnotation(RequestParam.class);
        String paramName = requestParam.value();
        String paramValue = request.getParameter(paramName);
        if (param.getType() == byte.class) {
          args[i] = Byte.parseByte(paramValue);
        } else if (param.getType() == short.class) {
          args[i] = Short.parseShort(paramValue);
        } else if (param.getType() == int.class) {
          args[i] = Integer.parseInt(paramValue);
        } else if (param.getType() == long.class) {
          args[i] = Long.parseLong(paramValue);
        } else if (param.getType() == float.class) {
          args[i] = Float.parseFloat(paramValue);
        } else if (param.getType() == double.class) {
          args[i] = Double.parseDouble(paramValue);
        } else if (param.getType() == boolean.class) {
          args[i] = Boolean.parseBoolean(paramValue);
        } else if (param.getType() == char.class) {
          args[i] = paramValue.charAt(0);
        } else if (param.getType() == Date.class) {
          args[i] = Date.valueOf(paramValue);
        } else {
          args[i] = paramValue;
        }
      }
    }
    return args;
  }
}
