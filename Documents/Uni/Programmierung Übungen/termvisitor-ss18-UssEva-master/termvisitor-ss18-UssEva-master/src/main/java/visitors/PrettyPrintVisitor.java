package visitors;

import expressions.*;

import java.io.ByteArrayOutputStream;

public class PrettyPrintVisitor implements Visitor {

  private int outContent;


  @Override
  public void visit(Expression pExpression) {
    pExpression.accept(this);
  }

  @Override
  public void visit(Literal pLiteralExpression) {
    outContent = pLiteralExpression.getValue();
  }

  @Override
  public void visit(Brackets pBracketExpression) {
    visit(pBracketExpression.getExpression());
  }

  @Override
  public void visit(Addition pAdditionExpression) {

    visit(pAdditionExpression.getLeftHandSide());
    final int result1 = outContent;

    visit(pAdditionExpression.getRightHandSide());
    final int result2 = outContent;

    outContent = (result1 + result2);

  }

  @Override
  public void visit(Subtraction pSubtractionExpression) {
    visit(pSubtractionExpression.getLeftHandSide());
    final int result1 = outContent;

    visit(pSubtractionExpression.getRightHandSide());
    final int result2 = outContent;

    outContent = (result1 - result2);

  }

  @Override
  public void visit(Multiplication pMultiplicationExpression) {
    visit(pMultiplicationExpression.getLeftHandSide());
    final int result1 = outContent;

    visit(pMultiplicationExpression.getRightHandSide());
    final int result2 = outContent;

    outContent = (result1 * result2);

  }

  @Override
  public void visit(Division pDivisionExpression) {
    visit(pDivisionExpression.getLeftHandSide());
    final int result1 = outContent;

    visit(pDivisionExpression.getRightHandSide());
    final int result2 = outContent;

    outContent = (result1 / result2);

  }
}
