import java.awt.Color;

public class Basin extends DrawableRectangle implements Touchable{
  private Water water;
  private BasinWall lWall, rWall;
  private BasinFloor floor;
  public Basin(double x, double y, double size) {
    super(x, y, size*0.75, size*3, Math.PI, Color.GRAY);
    water = new Water(x, y, size);
    lWall = new BasinWall(x-size*1.375, y, size);
    rWall = new BasinWall(x+size*1.375, y, size);
    floor = new BasinFloor(x, 0.25, size);
    this.addChild(water);
    this.addChild(lWall);
    this.addChild(rWall);
    this.addChild(floor);
  }

  public void drawTopLayer(Draw draw) {
    water.drawSelf(draw);
    lWall.drawSelf(draw);
    rWall.drawSelf(draw);
    floor.drawSelf(draw);
  }

  public boolean isTouched(double x, double y) {
    return isHTouched(x) && isVTouched(y);
  }

  public boolean isVTouched(double y) {
    double [] tY = this.getYCoords();
    if(y > tY[0] || y < tY[3]) return false;
    return true;
  }

  public boolean isHTouched(double x) {
    double [] tX = this.getXCoords();
    if(x > tX[0] || x < tX[1]) return false;
    return true;
  }
}
