package com.ebay.web.controller;

import com.ebay.web.model.Play;
import com.ebay.web.model.RuleResult;
import com.ebay.web.model.SodokuModel;
import com.ebay.web.view.NIView;
import com.ebay.web.view.NewChoiceFBView;
import com.ebay.web.view.View;
import com.sun.javafx.PlatformUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NewNumberEnteredController implements  SodukuController {

  @Override
  public boolean matches(String pathInfo) {
    return pathInfo.equals("/json.html");
  }

  @Override
  public View handle(HttpServletRequest req) {
    int line = Integer.parseInt(req.getParameter("line"));
    int col = Integer.parseInt(req.getParameter("col"));
    int v = Integer.parseInt(req.getParameter("v"));

    SodokuModel m = SodokuMainController.getHardcodedModel();
    Play p = new Play(line,col,v);
    List<RuleResult> res = m.applyRules(p);
    if (res.size()==0){
      m.set(p.getPosition(),p.getChoice());
    }

    return new NewChoiceFBView(res);
  }
}
