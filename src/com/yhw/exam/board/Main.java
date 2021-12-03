package com.yhw.exam.board;

import java.util.*;

public class Main {
  static List<Article> articles;
  static int articlesLastId;
  static {
    articles = new ArrayList<>();
    articlesLastId = 0;
  }

  static void makeTestData(List<Article> list) {
    for (int i = 0; i < 50; i++) {
      int id = i + 1;
      list.add((new Article(id, "제목" + id, "내용" + id)));
    }
    list.add((new Article(51, "안녕", "ㅋㅋ")));
    list.add((new Article(52, "ㅋㅋ", "안녕")));
  }

  public static void main(String[] args) {
    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    List<Article> filteredArticles1 = new ArrayList<>();
    makeTestData(articles);

    while (true) {
      System.out.printf("명령) ");
      String cmd = Container.sc.nextLine();

      Rq rq = new Rq(cmd);
      Map<String, String> params = rq.getParams();

      int pageCount = 0;

      if (articles.size() > 0) {
        articlesLastId = articles.get(articles.size() - 1).id;
      }

      if (cmd.equals("exit")) {
        break;
      } else if (rq.getUrlPath().equals("/usr/article/write")) {
        actionUsrArticleWrite(rq);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        actionUsrArticleDetail(rq);
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        actionUsrArticleList(rq);
      } else {
        System.out.printf("입력 받은 명령어 : %s\n", cmd);
      }
    }
    System.out.println("== 프로그램 종료 ==");
  }

  private static void actionUsrArticleDetail(Rq rq) {
    Map<String, String> params = rq.getParams();

    if (params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }
    if (id > articles.size()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }
    Article article = articles.get(id - 1);
    System.out.println("- 게시물 상세 내용 -");
    System.out.println("번호 : " + article.id);
    System.out.println("제목 : " + article.title);
    System.out.println("내용 : " + article.body);
  }

  private static void actionUsrArticleWrite(Rq rq) {
    System.out.println("- 게시물 등록 -");
    System.out.printf("제목 : ");
    String title = Container.sc.nextLine();
    System.out.printf("내용 : ");
    String body = Container.sc.nextLine();

    Article article = new Article();

    int id = articlesLastId + 1;
    articlesLastId = id;

    article.id = id;
    article.title = title;
    article.body = body;

    System.out.println("생성된 게시물 객체 : " + article);
    System.out.println(id + "번 게시물이 입력 되었습니다.");

    articles.add(article);

  }

  private static void actionUsrArticleList(Rq rq) {
    Map<String, String> params = rq.getParams();
    String searchKeyword = params.get("searchKeyword");
    List<Article> filteredArticles2 = new ArrayList<>();

    System.out.println("- 게시물 리스트 -");
    System.out.println("---------------");
    System.out.println("번호 / 제목");
    System.out.println("---------------");

    List<Article> sortedArticles = articles;

    boolean orderByIdDesc = true;

    if (params.containsKey("orderBy") && params.get("orderBy").equals("idAsc")) {
      orderByIdDesc = false;
    }

    if (orderByIdDesc && searchKeyword == null) {
      sortedArticles = Util.reverseList(sortedArticles);
    }

    for (Article article : sortedArticles) {
      if (searchKeyword == null) {
        System.out.printf("%d / %s\n", article.id, article.title);
      }
    }

    if (params.containsKey("searchKeyword")) {
      for (Article article : articles) {
        if (article.title.contains(searchKeyword) || article.body.contains(searchKeyword)) {
          filteredArticles2.add(article);

          System.out.printf(" %d / %s %s \n", article.id, article.title, article.body);
        }
      }
    }
  }
}





