import java.awt.Color;

public class RobotClient implements DrawListener{
  private Draw draw = new Draw();
  private Basin basin = new Basin(5, 0.75, 1);
  private HandWashingCompleteRobot robot = new HandWashingCompleteRobot(2.5, 0, 0.25);
  private Color bgColor = new Color(192, 192, 255);

  public RobotClient() {
    draw.addListener(this);
    draw.setXscale(0, 7);
    draw.setYscale(0, 7);
    drawAll();
  }

  private void drawAll() {
    draw.clear(bgColor);
    robot.drawSelf(draw);
    basin.drawSelf(draw);
    robot.getArm(0).drawSelf(draw);
    robot.getArm(1).drawSelf(draw);
    basin.drawTopLayer(draw);
    draw.show();
  }

  public void mousePressed(double mouseX, double mouseY) {
    double basinX = basin.getX();

    if (basin.isTouched(mouseX, mouseY)) {
      if (robot.bothHandsCanFit(basin)) robot.soakHands();
      else robot.goToX(basinX, "THE WATER BASIN");
    }
    else if (robot.isTorsoHTouched(mouseX)) robot.squat();
    else robot.goToX(mouseX, "YOUR CURSOR");

    drawAll();
  }
  
  public static void main(String[] args) {
      new RobotClient();
  }
}
