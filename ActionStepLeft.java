public class ActionStepLeft extends ActionStep{
  public ActionStepLeft(CompleteRobot robot) {
    super(robot);
  }

  @Override
  public void act() {
    super.act();
    this.getRobot().move(-getLastDistance(), 0);
  }
  
}
