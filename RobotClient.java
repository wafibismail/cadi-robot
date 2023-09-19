import java.awt.Color;

public class RobotClient implements DrawListener{
  private Draw draw = new Draw();
  private Basin basin = new Basin(5, 0.75, 1);
  private HandWashingCompleteRobot hwRobot = new HandWashingCompleteRobot(2.5, 0, 0.25);
  private CompleteRobot anyRobot = new CrabCompleteRobot(7.5, 0, 0.15);
  private Color bgColor = new Color(192, 192, 255);

  public RobotClient() {
    draw.addListener(this);
    draw.setXscale(0, 10);
    draw.setYscale(0, 10);
    drawAll();
  }

  private void drawAll() {
    draw.clear(bgColor);
    hwRobot.drawSelf(draw);
    basin.drawSelf(draw);
    hwRobot.getArm(0).drawSelf(draw);
    hwRobot.getArm(1).drawSelf(draw);
    basin.drawTopLayer(draw);
    anyRobot.drawSelf(draw);
    draw.show();
  }

  public void mousePressed(double mouseX, double mouseY) {

    // Actions for the first Robot (specific subclass)
    if (basin.isTouched(mouseX, mouseY)) {
      hwRobot.useBasin(basin);
    }
    else if (hwRobot.isTorsoHTouched(mouseX)) hwRobot.squat();
    else hwRobot.goToX(mouseX, "YOUR CURSOR");

    // A simple action for the second Robot (any subclass)
    anyRobot.goToX(mouseX, "YOUR CURSOR");

    drawAll();
  }
  
  public static void main(String[] args) {
      new RobotClient();
  }
}
