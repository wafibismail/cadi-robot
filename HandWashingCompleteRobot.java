public class HandWashingCompleteRobot extends CompleteRobot{
  public HandWashingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeAction(new ActionSquat(this));
    say("Hello! I am the hand-soaking robot.");
  }

  private boolean bothHandsCanFit(Touchable obj) {
    double leftHandX = getArm(0).getX()-0.25;
    double rightHandX = getArm(1).getX()+0.25;

    return obj.isHTouched(leftHandX) && obj.isHTouched(rightHandX);
  }

  private void soakHands() {
    act(Direction.DOWN);
    say("Soaking my hands!");
  }
  
  public void squat() {
    act();
    say("I am performing SQUATS");
  }

  public void useBasin(Basin basin) {
    if (bothHandsCanFit(basin)) soakHands();
    else goToX(basin.getX(), "THE WATER BASIN");
  }
}
