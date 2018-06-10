package de.uni_passau.fim.infosun.se2.mvc_rng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** The controller keeps the communication between model and view */
class Controller implements ActionListener {

  private final Model model;
  private final View view;

  Controller(final View pView) {
    model = new Model();
    view = pView;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Parses the user's input and hands it to the model.  Pushes the result to the view afterwards.
   */
  @Override
  public void actionPerformed(final ActionEvent pActionEvent) {

    String number = view.getTextField().getText();
    int randomNumber = Integer.parseInt(number);


    try {
      model.check(randomNumber);
      if(model.check(randomNumber) == Model.Correctness.SMALL){
        view.getResultLabel().setText(randomNumber+ " is too small.");
      }
      if(model.check(randomNumber) == Model.Correctness.LARGE){
        view.getResultLabel().setText(randomNumber+ " is too large.");
      }
      if (model.check(randomNumber) == Model.Correctness.CORRECT)
        view.getResultLabel().setText("Congratulation, you won! "+ model.getNumberOfTries() +" tries.");
    } catch (Model.InvalidArgumentException e) {
      e.printStackTrace();
    }


  }

}





