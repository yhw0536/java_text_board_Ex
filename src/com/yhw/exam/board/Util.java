package com.yhw.exam.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    Map<String, String> params = new HashMap<>();
    String[] urlBits = url.split("\\?", 2);
    if (urlBits.length == 1) {
      return params;
    }
    String queryStr = urlBits[1];
    for (String bit : queryStr.split("&")) {
      String[] bitBits = bit.split("=", 2);
      if (bitBits.length == 1) {
        continue;
      }
      params.put(bitBits[0], bitBits[1]);
    }
    return params;
  }

  static String getUrlPathFromUrl(String url) {
    return url.split("\\?", 2)[0];
  }

  public static <T> List<T> reverseList(List<T> list) {
    List<T> reverse = new ArrayList<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      reverse.add(list.get(i));
    }
    return reverse;
  }
}