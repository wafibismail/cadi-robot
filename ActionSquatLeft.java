public class ActionSquatLeft extends ActionSquat{
  public ActionSquatLeft(CompleteRobot robot) {
    super(robot);
  }

  @Override
  public void act() {
    super.act();
    this.getRobot().move(-getLastDistance(), 0);
  }
  
}
