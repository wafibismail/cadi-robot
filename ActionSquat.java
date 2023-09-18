public class ActionSquat extends Action{
  private final double maxAngle = Math.PI;
  private final double minAngle = Math.PI/5;
  private double turnAngle = Math.PI/5;
  private double lastDistance;

  public ActionSquat(CompleteRobot robot) {
    super(robot);
  }

  protected double getLastDistance() {
    return this.lastDistance;
  }

  @Override
  public void act() {
    super.act();
    CompleteRobot robot = this.getRobot();

    LimbSegment lLeg = robot.getLeg(0);
    LimbSegment rLeg = robot.getLeg(1);

    if (rLeg.getRotation() <= minAngle)
      turnAngle = minAngle;
    else if (rLeg.getRotation() >= maxAngle)
      turnAngle = -minAngle;

    double x0 = lLeg.getExtremityXEnd();

    lLeg.rotate(turnAngle);
    rLeg.rotate(turnAngle);

    double x1 = lLeg.getExtremityXEnd();

    this.lastDistance = Math.abs(x1-x0);

    this.groundRobot();
  }
}
