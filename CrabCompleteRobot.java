public class CrabCompleteRobot extends CompleteRobot{
  // This subclass is almost an exact copy of CompleteRobot,
  // but with a different way of walking, i.e., Crabstep
  public CrabCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeMoveAction(new ActionCrabstep(this));
    say("And I am the crab-walking robot.");
  }
}
