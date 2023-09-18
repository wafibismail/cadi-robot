public class Action {
  private CompleteRobot robot;

  protected CompleteRobot getRobot() {
    return this.robot;
  }

  protected void groundRobot() {
    CompleteRobot robot = this.getRobot();

    LimbSegment lLeg = robot.getLeg(0);
    robot.move(0, -lLeg.getExtremityYEnd());
  }

  public Action (CompleteRobot robot) {
    this.robot = robot;
  }

  public void act() {
    this.groundRobot();
  }
}
