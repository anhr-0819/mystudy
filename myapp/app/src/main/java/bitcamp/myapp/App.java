package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    MainMenu main = new MainMenu();
    main.execute();
    Prompt.close();
  }
}
