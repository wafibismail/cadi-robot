public class CompleteRobot extends HeadTorsoArmsLegs{
  private ActionStep moveAction;
  private Action currentAction;
  private Speech speech;
  public CompleteRobot(double x, double y, double radius) {
    super(x, y, radius);

    this.moveAction = new ActionStep(this);
    this.currentAction = new Action(this);
    this.moveAction.groundRobot();
    this.speech = new Speech(x, getForeHeadY() + radius);
    addChild(speech);
  }

  protected void changeAction(Action newAction) {
    this.currentAction = newAction;
  }

  protected void act() {
    this.currentAction.act();
  }

  protected void act(Direction dir) {
    this.currentAction.act(dir);
  }

  protected void toLeft() {
    this.moveAction.act(Direction.LEFT);
  }

  protected void toRight() {
    this.moveAction.act(Direction.RIGHT);
  }

  protected void say(String speechText) {
    speech.changeText(speechText);
  }
}
