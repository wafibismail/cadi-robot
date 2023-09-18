public class ActionSquatRight extends ActionSquat{
  public ActionSquatRight(CompleteRobot robot) {
    super(robot);
  }

  @Override
  public void act() {
    super.act();
    this.getRobot().move(getLastDistance(), 0);
  }
  
}
