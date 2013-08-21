package com.ebay.web.model;

public interface Rule {


  /**
   * Validates if the given play is valid for that rule.
   */
  public RuleResult validate(SodokuModel model, Play play);

}
