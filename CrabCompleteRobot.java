public class CrabCompleteRobot extends CompleteRobot{
  public CrabCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeMoveAction(new ActionCrabstep(this));
    say("And I am the crab-walking robot.");
  }
}
