import java.awt.Color;

public class Water extends DrawableRectangle implements Touchable{
  public Water(double x, double y, double size) {
    super(x, y, size/2, size*2.5, Math.PI, new Color(0, 255, 255, 128));
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
