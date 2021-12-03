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

  public String getUrlPath() {
    return getPath;
  }
}