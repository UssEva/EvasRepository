package de.uni_passau.fim.infosun.se2.mvc_rng;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class View extends JFrame {

  private final JTextField inputField;
  private final JLabel resultLabel;

  View() {
    final ActionListener controller = new Controller(this);

    inputField = new JTextField();
    inputField.addActionListener(controller);
    resultLabel = new JLabel("Can you guess my chosen number?");

    final JButton submit = new JButton("Guess…");
    submit.setMnemonic('g');
    submit.addActionListener(controller);

    final Container container = getContentPane();
    container.setLayout(new GridLayout(2, 2));
    container.add(inputField);
    container.add(submit);
    container.add(resultLabel);
    container.add(new JLabel());

    pack();
    setTitle("Guess my Number");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  JTextField getTextField() {
    return inputField;
  }

  JLabel getResultLabel() {
    return resultLabel;
  }
}
