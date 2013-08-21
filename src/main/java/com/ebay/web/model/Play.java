package com.ebay.web.model;

public class Play {

  private final Position p;
  private final int choice;

  public Position getPosition() {
    return p;
  }

  public int getChoice() {
    return choice;
  }

  public Play(int line, int col, int value) {
    this(new Position(line, col), value);
  }

  public Play(Position p, int choice) {
    validate(p.getLine(), "line");
    validate(p.getCol(), "col");
    validate(choice - 1, "choice");
    this.p = p;
    this.choice = choice;
  }


  private void validate(int value, String what) {
    if (value >= 9 || value < 0) {
      throw new RuntimeException(what + " is wrong " + value);
    }
  }

  @Override
  public String toString(){
    return "["+p.getLine()+","+p.getCol()+"]="+choice;
  }

}
