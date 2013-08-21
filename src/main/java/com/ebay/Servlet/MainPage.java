package com.ebay.Servlet;

import com.ebay.web.controller.NIController;
import com.ebay.web.controller.NewNumberEnteredController;
import com.ebay.web.controller.SodokuMainController;
import com.ebay.web.controller.SodukuController;
import com.ebay.web.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage extends HttpServlet {

  private static final List<SodukuController> controllers = new ArrayList<SodukuController>();

  public MainPage() {

    controllers.add(new SodokuMainController());
    controllers.add(new NewNumberEnteredController());
    // NI one
    controllers.add(new NIController());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
//    response.getWriter().write("Hello world");
//    response.getWriter().close();
    View v = process(req);
    try {
      String page = v.render();
      response.getWriter().write(page);

    } catch (Exception e) {
      response.setStatus(500);
      response.getWriter().write(e.getMessage());
    } finally {
      response.getWriter().close();
    }
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
    View v = process(req);
    try {
      String page = v.render();
      response.getWriter().write(page);

    } catch (Exception e) {
      response.setStatus(500);
      response.getWriter().write(e.getMessage());
    } finally {
      response.getWriter().close();
    }
  }


  private View process(HttpServletRequest req) {
    String pathInfo = req.getPathInfo();
    for (SodukuController controller : controllers) {
      if (controller.matches(pathInfo)) {
        return controller.handle(req);
      }
    }
    throw new RuntimeException("No controller found for " + pathInfo);
  }
}
