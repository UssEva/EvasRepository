package visitors;

import expressions.*;

public class CountVisitor implements Visitor {

  private int counter;

  public int getResult() {
    return counter;
  }

  @Override
  public void visit(Expression pExpression) {
    pExpression.accept(this);
  }

  @Override
  public void visit(Literal pLiteralExpression) {}

  @Override
  public void visit(Brackets pBracketExpression) {
    visit(pBracketExpression.getExpression());
  }

  @Override
  public void visit(Addition pAdditionExpression) {
    visit(pAdditionExpression.getLeftHandSide());
    visit(pAdditionExpression.getRightHandSide());
    counter++;
  }
  @Override
  public void visit(Subtraction pSubtractionExpression){
    visit(pSubtractionExpression.getLeftHandSide());
    visit(pSubtractionExpression.getRightHandSide());
    counter++;
  }

  @Override
  public void visit(Multiplication pMultiplicationExpression){
    visit(pMultiplicationExpression.getLeftHandSide());
    visit(pMultiplicationExpression.getRightHandSide());
    counter++;
  }

  @Override
  public void visit(Division pDivisionExpression){
    visit(pDivisionExpression.getLeftHandSide());
    visit(pDivisionExpression.getRightHandSide());
    counter++;
  }
}


