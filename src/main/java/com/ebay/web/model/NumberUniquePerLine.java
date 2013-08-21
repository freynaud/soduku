package com.ebay.web.model;

import java.util.ArrayList;
import java.util.List;

public class NumberUniquePerLine implements Rule {

  public final int line;


  public NumberUniquePerLine(int line) {
    this.line = line;
  }


  @Override
  public RuleResult validate(SodokuModel model, Play play) {
    List<Position> failed = new ArrayList<Position>();
    if (play.getPosition().getLine() == line) {
      // iterate on column
      for (int j = 0; j < 9; j++) {
        // equals itself.
        if (j == play.getPosition().getCol()) {
          continue;
        }
        Position p = new Position(line, j);
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
