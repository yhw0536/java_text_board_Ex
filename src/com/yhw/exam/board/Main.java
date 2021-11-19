package com.yhw.exam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Article {
  int id;
  String title;
  String body;

  public Article() {

  }

  public Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
  }
}

public class Main {

  static void makeTestData(List<Article> list) {
    list.add((new Article(1, "제목1", "내용1")));
    list.add((new Article(2, "제목2", "내용2")));
    list.add((new Article(3, "제목3", "내용3")));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    int lastArticlesId = 0;

    List<Article> list = new ArrayList<>();

    makeTestData(list);

    if (list.size() > 0) {
      lastArticlesId = list.get(list.size() - 1).id;
    }

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.equals("/usr/article/write")) {
        System.out.println("- 게시물 등록 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();

        Article article = new Article();

        int id = lastArticlesId + 1;
        lastArticlesId = id;

        article.id = id;
        article.title = title;
        article.body = body;

        System.out.println("생성된 게시물 객체 : " + article);
        System.out.println(id + "번 게시물이 입력 되었습니다.");

        list.add(article);

      } else if (cmd.equals("/usr/article/detail")) {
        if (list.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }
        Article article = list.get(list.size() - 1);
        System.out.println("- 게시물 상세 내용 -");
        System.out.println("번호 : " + article.id);
        System.out.println("제목 : " + article.title);
        System.out.println("내용 : " + article.body);
      } else if (cmd.equals("/usr/article/list")) {

        System.out.println("- 게시물 리스트 -");
        System.out.println("---------------");
        System.out.println("번호 / 제목");
        System.out.println("---------------");
        for (int i = list.size() - 1; i >= 0; i--) {
          Article article = list.get(i);
          System.out.printf(" %d / %s \n", article.id, article.title);
        }
      } else {
        System.out.printf("입력 받은 명령어 : %s\n", cmd);
      }
    }
    System.out.println("== 프로그램 종료 ==");
  }
}
