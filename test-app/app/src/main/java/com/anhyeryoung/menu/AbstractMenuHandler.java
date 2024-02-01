package com.anhyeryoung.menu;

import  com.anhyeryoung.util.AnsiEscape;
import com.anhyeryoung.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Prompt prompt;
  protected Menu menu;

  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    this.printMenuTitle(menu.getTitle());
    this.menu = menu;

    this.action();
  }

  private void printMenuTitle(String title) {
    System.out.printf( "%s %s %s \n" , AnsiEscape.GREEN_BACKGROUND,title,AnsiEscape.RESET);
  }

  protected abstract void action();
}
