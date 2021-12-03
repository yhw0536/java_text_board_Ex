package com.yhw.exam.board;

import java.util.Scanner;

public class Container {
  static UsrArticleController usrArticleController;
  static Scanner sc;
   static {
     sc = new Scanner(System.in);
     usrArticleController = new UsrArticleController();
   }
}
