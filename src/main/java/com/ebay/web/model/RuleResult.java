package com.ebay.web.model;

import java.util.List;

public class RuleResult {

  private final Rule rule;
  private final List<Position> positions;

  public RuleResult(Rule rule, List<Position> positions) {
    this.rule = rule;
    this.positions = positions;
  }


  public boolean isFullfiled() {
    return positions.size() == 0;
  }

  public List<Position> getViolatedPositions() {
    return positions;
  }

  @Override
  public String toString() {
    return rule.getClass().getSimpleName() + " isn't ok for " + positions;
  }
}
