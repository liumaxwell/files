package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.List;

import edu.cs3500.spreadsheets.sexp.Parser;

public class Builder implements WorksheetReader.WorksheetBuilder<Worksheet> {
  private List<List<Cell>> cells;

  @Override
  public WorksheetReader.WorksheetBuilder<Worksheet> createCell(int col, int row, String contents) {
    try {
      cells.get(col - 1);
    } catch (IndexOutOfBoundsException x) {
      for(int i = 0; i < col - cells.size(); i++) {
        cells.add(new ArrayList<Cell>());
      }
    }

    try {
      cells.get(col - 1).get(row - 1);
    } catch (IndexOutOfBoundsException x) {
      for (int z = 0; z < row - cells.get(col - 1).size(); z++) {
        cells.get(col - 1).add(new ValueCell(""));
      }
    }

    if (contents == null) {
      Cell temp5 = new ValueCell("");
      cells.get(col-1).add(row-1,temp5);
    }
    else if (!contents.substring(0, 1).equals("=")) {
      switch (contents) {
        case "true":
          Cell temp = new ValueCell(true);
          cells.get(col-1).add(row-1,temp);
        case "false":
          Cell temp2 = new ValueCell(false);
          cells.get(col-1).add(row-1,temp2);
        default :
          try {
            Double num = Double.parseDouble(contents);
            Cell temp3 = new ValueCell(num);
            cells.get(col-1).add(row-1,temp3);
          }
          catch (NumberFormatException e) {
            Cell temp4 = new ValueCell(contents);
            cells.get(col-1).add(row-1,temp4);
          }
      }

    }
    else {
      Parser parses = new Parser();
      parses.parse(contents);
    }

    return this;
  }

  @Override
  public Worksheet createWorksheet() {
    return null;
  }
}
