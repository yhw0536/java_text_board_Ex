package com.yhw.exam.board;

public class Article {
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