public class ActionSquat extends ActionStep{
  public ActionSquat(CompleteRobot robot) {
    super(robot, Math.PI, Math.PI/5, Math.PI/5);
  }

  @Override
  public void act(Direction dir) {
    super.act(dir);
    if (dir==Direction.DOWN) {
      LimbSegment rLeg = this.getRobot().getLeg(1);

      double currentRotation = rLeg.getRotation();
      if (currentRotation == Math.PI/5*2 && getTurnAngle() > 0) {
        while (rLeg.getRotation() > Math.PI/5*1)
          super.act();
      }
      System.out.println(rLeg.getRotation());
    }
  }
}
