package edu.cs3500.spreadsheets;

import org.junit.Test;

import java.util.Scanner;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.Sexp;

import static junit.framework.TestCase.assertEquals;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * The main entry point.
   * @param args any command-line arguments
   */
  public static void main(String[] args) {
    /*
      TODO: For now, look in the args array to obtain a filename and a cell name,
      - read the file and build a model from it, 
      - evaluate all the cells, and
      - report any errors, or print the evaluated value of the requested cell.
    */
    Parser p = new Parser();
    String s = "test > test";



  }

  @Test
  public void testS() {
    Parser p = new Parser();
    Sexp s = p.parse("(< (SUM A1:A4) (PRODUCT B2:C5 D8))");
    assertEquals(true, s instanceof SList);
    assertEquals("", s);
  }
}
