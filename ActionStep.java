public class ActionStep extends Action {
  private final double maxAngle;
  private final double minAngle;
  private double turnAngle;
  private double lastDistance;

  public ActionStep(CompleteRobot robot) {
    super(robot);
    this.maxAngle = Math.PI;
    this.minAngle = Math.PI/5*4;
    this.turnAngle =  Math.PI/5;
  }

  public ActionStep(CompleteRobot robot, double maxAngle, double minAngle, double turnAngle) {
    super(robot);
    this.maxAngle = maxAngle;
    this.minAngle = minAngle;
    this.turnAngle = turnAngle;
  }

  @Override
  public void act() {
    super.act();
    CompleteRobot robot = this.getRobot();

    LimbSegment lLeg = robot.getLeg(0);
    LimbSegment rLeg = robot.getLeg(1);

    if (rLeg.getRotation() <= minAngle) {
      turnAngle = Math.abs(turnAngle);
    }
    else if (rLeg.getRotation() >= maxAngle) {
      turnAngle = -Math.abs(turnAngle);
    }

    double x0 = lLeg.getExtremityXEnd();

    lLeg.rotate(turnAngle);
    rLeg.rotate(turnAngle);

    double x1 = lLeg.getExtremityXEnd();

    this.lastDistance = Math.abs(x1-x0);

    this.groundRobot();
  }
  
  public void act(Direction dir) {
    this.act();
    if (dir==Direction.LEFT)
      this.getRobot().move(-this.lastDistance, 0);
    else if (dir==Direction.RIGHT)
      this.getRobot().move(this.lastDistance, 0);
  }

  protected double getTurnAngle() {
    return this.turnAngle;
  }
}
