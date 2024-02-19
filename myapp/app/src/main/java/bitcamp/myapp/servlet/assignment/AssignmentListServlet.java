package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/assignment/list")
public class AssignmentListServlet extends GenericServlet {

  private AssignmentDao assignmentDao;

  public AssignmentListServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {

    servletResponse.setContentType("text/html;charset=UTF-8");
    PrintWriter out = servletResponse.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF - 8'>");
    out.println("<title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>과제</h1>");

    out.println("<a href='/assignment/form.html'>새 과제</a>");

    try {
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr> <th>번호</th> <th>제목</th> <th>제출마감일</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");

      List<Assignment> list = assignmentDao.findAll();

      for (Assignment assignment : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/assignment/view?no=%1$d'>%s</a></td> <td>%s</td></tr>\n",
            assignment.getNo(),
            assignment.getTitle(),
            assignment.getDeadline());
      }

      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
