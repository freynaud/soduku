package com.ebay.web.view;

import javax.servlet.http.HttpServletRequest;

public class NIView implements View {

  private final HttpServletRequest req;

  public NIView(HttpServletRequest req) {
    this.req = req;
  }


  @Override
  public String render() {
    return "Not implemented : "+req.getPathInfo();
  }
}
