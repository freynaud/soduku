package com.ebay.web.controller;

import com.ebay.web.view.NIView;
import com.ebay.web.view.View;

import javax.servlet.http.HttpServletRequest;

public class NIController implements SodukuController {

  @Override
  public boolean matches(String pathInfo) {
    return true;
  }

  @Override
  public View handle(HttpServletRequest req) {
    return new NIView(req);
  }
}
