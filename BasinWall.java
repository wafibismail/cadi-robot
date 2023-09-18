import java.awt.Color;

public class BasinWall extends DrawableRectangle{
  public BasinWall(double x, double y, double size) {
    super(x, y, size*0.75, size/4, Math.PI, Color.GRAY);
  }
}
