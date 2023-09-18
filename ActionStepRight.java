public class ActionStepRight extends ActionStep{
  public ActionStepRight(CompleteRobot robot) {
    super(robot);
  }

  @Override
  public void act() {
    super.act();
    this.getRobot().move(getLastDistance(), 0);
  }
  
}
