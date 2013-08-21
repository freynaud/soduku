package com.ebay.web.view;

import com.ebay.web.model.RuleResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class NewChoiceFBView implements View {

  private final List<RuleResult> results;

  public NewChoiceFBView(List<RuleResult> results) {
    this.results = results;
  }


  @Override
  public String render() {
    try {
      return new JSONObject().put("data", results.toString()).toString(2);
    } catch (JSONException e) {
      return null;
    }
  }
}
