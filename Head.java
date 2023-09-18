import java.awt.Color;

public class Head extends DrawableCircle{
  private Eye lEye, rEye;
  public Head(double x, double y, double radius) {
    super(x, y, radius, Color.WHITE);

    lEye = new Eye(x - radius/3, y + radius/3, radius/8);
    rEye = new Eye(x + radius/3, y + radius/3, radius/8);

    addChild(lEye);
    addChild(rEye);
  }

  public Eye getEye(int index) {
    return index == 0 ? lEye : rEye;
  }

  public double getForeHeadY() {
    return this.getY() + this.getRadius();
  }
}
