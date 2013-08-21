package com.ebay.web.controller;

import com.ebay.web.model.Position;
import com.ebay.web.model.SodokuModel;
import com.ebay.web.view.SodukuGridView;
import com.ebay.web.view.View;

import javax.servlet.http.HttpServletRequest;

public class SodokuMainController implements SodukuController{

  private static SodokuModel m;

  @Override
  public boolean matches(String pathInfo) {
    return pathInfo.equals("/index.html");
  }

  @Override
  public View handle(HttpServletRequest req) {
    // TODO get model from session
    if (m==null){
      m = new SodokuModel();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 9; j++) {
          if( i==2 && j==0){
            continue;
          }
          int value = (3*i) + j + 1;
          while (value >=10){
            value-=9;
          }
          m.set(new Position(i, j), value);
        }
      }
    }
    return new SodukuGridView(m);
  }

  public static SodokuModel getHardcodedModel(){
    return m;
  }
}
