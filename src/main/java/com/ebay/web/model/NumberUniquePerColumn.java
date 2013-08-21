package com.ebay.web.model;

import java.util.ArrayList;
import java.util.List;

public class NumberUniquePerColumn implements Rule {

  public final int col;


  public NumberUniquePerColumn(int col) {
    this.col = col;
  }


  @Override
  public RuleResult validate(SodokuModel model, Play play) {

    List<Position> failed = new ArrayList<Position>();
    if (play.getPosition().getCol() == col) {
      // iterate on line
      for (int i = 0; i < 9; i++) {
        // equals itself.
        if (i == play.getPosition().getLine()) {
          continue;
        }
        Position p = new Position(i, col);
        int value = model.get(p);
        if (value == play.getChoice()) {
          failed.add(p);
        }
      }
    }
    RuleResult result = new RuleResult(this, failed);
    return result;
  }
}
