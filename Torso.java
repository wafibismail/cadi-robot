import java.awt.Color;

public class Torso extends DrawableRectangle implements Touchable{
  public Torso(double x, double y, double h, double w) {
    super(x, y, h, w, Math.PI, Color.PINK);
  }
  public Torso(double x, double y, double radius) {
    super(x, y, radius*5, radius*3, Math.PI, Color.PINK);
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
