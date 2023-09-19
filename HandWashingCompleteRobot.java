public class HandWashingCompleteRobot extends CompleteRobot {
  public HandWashingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeAction(new ActionSquat(this));
  }

  public void goToX(double destX, String destLabel) {
    if (this.getX() < destX) {
      this.toRight();
      say("I am moving right towards " + destLabel);
    }
    else {
      this.toLeft();
      say("I am moving left towards " + destLabel);
    }
  }

  public boolean bothHandsCanFit(Touchable obj) {
    double robLeftX = getArm(0).getX()-0.25;
    double robRightX = getArm(1).getX()+0.25;

    return obj.isHTouched(robLeftX) && obj.isHTouched(robRightX);
  }

  public void soakHands() {
    act(Direction.DOWN);
    say("Soaking my hands!");
  }
  
  public void squat() {
    act();
    say("I am performing SQUATS");
  }
}
