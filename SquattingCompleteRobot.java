public class SquattingCompleteRobot extends CompleteRobot{
  // This subclass has a different Action i.e. ActionSquat.
  // It "performs squats" as its additional activity
  public SquattingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeAction(new ActionSquat(this));
    say("Hello! I am a squatting robot.");
  }

  public void squat() {
    act();
    say("I am performing SQUATS");
  }
}
