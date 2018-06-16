package de.uni_passau.fim.infosun.se2.mvc_rng;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(View::new);
  }
}
