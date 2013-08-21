package com.ebay.web.model;

public class Position {


  private int line;

  public int getLine() {
    return line;
  }

  private int col;

  public Position(int line, int col) {
    this.line = line;
    this.col = col;
  }

  public int getCol() {
    return col;
  }

  @Override
  public String toString() {
    return "[" + line + "," + col + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Position position = (Position) o;

    if (col != position.col) {
      return false;
    }
    if (line != position.line) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = line;
    result = 31 * result + col;
    return result;
  }
}
