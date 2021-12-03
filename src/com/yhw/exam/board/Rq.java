package com.yhw.exam.board;

import java.util.Map;

public class Rq {

  private String url;
  private String getPath;
  private Map<String, String> params;

  Rq(String url) {

    this.url = url;
    getPath = Util.getUrlPathFromUrl(this.url);
    params = Util.getParamsFromUrl(this.url);
  }

  public Map<String, String> getParams() {
    return params;
  }

  public int getIntParam(String paramName, int defaultValue) {
   if (params.containsKey(paramName) == false) {
     return defaultValue;
   }
   try {
     return Integer.parseInt(params.get(paramName));
   }
   catch (NumberFormatException e) {
     return defaultValue;
   }
  }
  public String getIntParam(String paramName, String defaultValue) {
    if (params.containsKey(paramName) == false) {
      return defaultValue;
    }
    try {
      return params.get(paramName);
    }
    catch (NumberFormatException e) {
      return defaultValue;
    }
  }
  public String getUrlPath() {
    return getPath;
  }
}