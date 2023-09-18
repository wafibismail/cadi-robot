public class CompleteRobot extends HeadTorsoArmsLegs{
  private ActionStep moveAction;
  private Action currentAction;
  public CompleteRobot(double x, double y, double radius) {
    super(x, y, radius);

    this.moveAction = new ActionStep(this);
    this.currentAction = new Action(this);
  }

  public void changeAction(Action newAction) {
    this.currentAction = newAction;
  }
  public void changeMoveAction(ActionStep newMoveAction) {
    this.moveAction = newMoveAction;
  }

  public void act() {
    this.currentAction.act();
  }

  public void act(Direction dir) {
    this.currentAction.act(dir);
  }

  public void toLeft() {
    this.moveAction.act(Direction.LEFT);
  }

  public void toRight() {
    this.moveAction.act(Direction.RIGHT);
  }

  public void say(Draw draw, String speechText) {
    draw.text(this.getX(), this.getForeHeadY()+this.getRadius(), speechText);
  }
}
