import java.awt.Color;

public class Head extends DrawableCircle{
  public Head(double x, double y, double radius) {
    super(x, y, radius, Color.WHITE);

    Eye lEye = new Eye(x - radius/3, y + radius/3, radius/8);
    Eye rEye = new Eye(x + radius/3, y + radius/3, radius/8);

    this.addChild(lEye);
    this.addChild(rEye);
  }

  public double getForeHeadY() {
    return this.getY() + this.getRadius();
  }
}
