package com.ebay.web.model;

import java.util.ArrayList;
import java.util.List;

public class SodokuModel {

  private int[][] grid = new int[9][9];
  private final List<Rule> rules = new ArrayList<Rule>();

  public SodokuModel() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = -1;
      }
    }

    for (int i = 0; i < 9; i++) {
      rules.add(new NumberUniquePerLine(i));
    }
    for (int j = 0; j < 9; j++) {
      rules.add(new NumberUniquePerColumn(j));
    }
  }


  public boolean isValid() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int value = grid[i][j];
        if (value == -1) {
          continue;
        }
        Position pos = new Position(i, j);
        Play p = new Play(pos, value);
        List<RuleResult> results = applyRules(p);
        if (results.size() != 0) {
          System.out.println("play :"+p+" is a fail");

          return false;
        }
      }
    }
    return true;
  }

  public SodokuModel set(Position p, int value) {
    if (value <= 0 || value >= 10) {
      throw new RuntimeException("wrong value : " + value);
    }
    int current = get(p);
    if (current != -1) {
      throw new RuntimeException("cannot change set value.");
    }
    grid[p.getLine()][p.getCol()] = value;

    return this;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < 9; i++) {
      if (i == 0) {
        b.append("[");
      }
      for (int j = 0; j < 9; j++) {
        int value = get(new Position(i, j));
        if (value == -1) {
          b.append(" ");
        } else {
          b.append(value);
        }
        if (j == 8) {
          b.append("]\n[");
        } else {
          b.append(" , ");
        }
      }
    }
    return b.toString();
  }


  public List<RuleResult> applyRules(Play play) {

    List<RuleResult> results = new ArrayList<RuleResult>();
    for (Rule rule : rules) {
      RuleResult res = rule.validate(this, play);
      if (!res.isFullfiled()) {
        results.add(res);
      }
    }
    return results;
  }

  public int get(Position p) {
    return grid[p.getLine()][p.getCol()];
  }


}
