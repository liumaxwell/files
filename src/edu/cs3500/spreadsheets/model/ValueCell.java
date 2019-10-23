package edu.cs3500.spreadsheets.model;

public class ValueCell implements Cell{
  private double doub;
  private boolean bool;
  private String str;
  private type t;

  public enum type {
    BOOLEAN, STRING, DOUBLE;
  }

  public ValueCell(double doub) {
    this.doub = doub;
    this.t = type.DOUBLE;
  }

  public ValueCell(boolean bool) {
    this.bool = bool;
    this.t = type.BOOLEAN;
  }

  public ValueCell(String str) {
    this.str = str;
    this.t = type.STRING;
  }

  public String getType() {
    switch(this.t) {
      case BOOLEAN:
        return "boolean";
      case DOUBLE:
        return "double";
      case STRING:
        return "string";
    }
    return null;
  }
}
