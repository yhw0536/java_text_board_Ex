package com.yhw.exam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

  void main() {
    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    List<Article> filteredArticles1 = new ArrayList<>();

    while (true) {
      System.out.printf("명령) ");
      String cmd = Container.sc.nextLine();

      Rq rq = new Rq(cmd);

      int pageCount = 0;

      if (cmd.equals("exit")) {
        break;
      } else if (rq.getUrlPath().equals("/usr/article/write")) {
        Container.usrArticleController.actionWrite(rq);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        Container.usrArticleController.actionDetail(rq);
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        Container.usrArticleController.actionList(rq);
      } else {
        System.out.printf("입력 받은 명령어 : %s\n", cmd);
      }
    }
    System.out.println("== 프로그램 종료 ==");
  }


}
