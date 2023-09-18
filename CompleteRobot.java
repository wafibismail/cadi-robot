public class CompleteRobot extends HeadTorsoArmsLegs{
  private Action moveLeftAction, moveRightAction;
  private Action currentAction;
  public CompleteRobot(double x, double y, double radius) {
    super(x, y, radius);

    this.moveLeftAction = new ActionStepLeft(this);
    this.moveRightAction = new ActionStepRight(this);
    this.currentAction = new Action(this);
  }

  public void changeAction(Action newAction) {
    this.currentAction = newAction;
  }
  public void changeMoveActions(Action newLeftAction, Action newRightAction) {
    this.moveLeftAction = newLeftAction;
    this.moveRightAction = newRightAction;
  }

  public void act() {
    this.currentAction.act();
  }

  public void toLeft() {
    this.moveLeftAction.act();
  }

  public void toRight() {
    this.moveRightAction.act();
  }

  public void say(Draw draw, String speechText) {
    draw.text(this.getX(), this.getForeHeadY()+this.getRadius(), speechText);
  }
}
