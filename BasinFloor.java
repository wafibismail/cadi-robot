import java.awt.Color;

public class BasinFloor extends DrawableRectangle{
  public BasinFloor(double x, double y, double size) {
    super(x, y, size*0.25, size*3, Math.PI, Color.GRAY);
  }
}
