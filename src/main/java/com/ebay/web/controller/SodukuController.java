package com.ebay.web.controller;

import com.ebay.web.view.View;

import javax.servlet.http.HttpServletRequest;

public interface SodukuController {

  boolean matches(String pathInfo);

  View handle(HttpServletRequest req);

}
