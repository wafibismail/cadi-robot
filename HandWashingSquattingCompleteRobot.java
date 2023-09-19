public class HandWashingSquattingCompleteRobot extends SquattingCompleteRobot{
  // This subclass has four more methods
  // both of which are required for it to "soak hands in water"
  // and "perform squats" as its additional activity
  public HandWashingSquattingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    say("Hello! I am a robot who can both squat and soak my hands!.");
  }

  private boolean bothHandsCanFit(Touchable obj) {
    double leftHandX = getArm(0).getExtremityXEnd()-0.25;
    double rightHandX = getArm(1).getExtremityXEnd()+0.25;

    // Check that both hands are within the x range covered by the object
    return obj.isHTouched(leftHandX) && obj.isHTouched(rightHandX);
  }

  private void soakHands() {
    act(Direction.DOWN);
    say("Soaking my hands!");
  }

  public void useBasin(Basin basin) {
    if (bothHandsCanFit(basin)) soakHands();
    else goToX(basin.getX(), "THE WATER BASIN");
  }
}
