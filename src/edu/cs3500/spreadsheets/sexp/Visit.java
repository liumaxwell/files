package edu.cs3500.spreadsheets.sexp;

import java.util.List;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.ValueCell;

public class Visit implements SexpVisitor<Cell> {
  @Override
  public Cell visitBoolean(boolean b) {
    return new ValueCell(b);
  }

  @Override
  public Cell visitNumber(double d) {
    return new ValueCell(d);
  }

  @Override
  public Cell visitSList(List<Sexp> l) {
    return l.get(0).accept(this);
  }

  @Override
  public Cell visitSymbol(String s) {
    return new ValueCell(s);
  }

  @Override
  public Cell visitString(String s) {
    return new ValueCell(s);
  }
}
