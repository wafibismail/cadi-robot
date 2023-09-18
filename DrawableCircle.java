import java.awt.Color;
import java.util.Arrays;

public abstract class DrawableCircle implements Drawable {
  private double radius;
  private double x, y;
  private Color fillColor;
  private Drawable [] bodyparts = {};
  
  public DrawableCircle(double x, double y, double radius, Color fillColor) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.fillColor = fillColor;
  }

  public void drawSelf(Draw draw) {
    // Draw fill
    draw.setPenColor(this.fillColor);
    draw.filledCircle(x, y, radius);
    // Draw outline
    draw.setPenColor(Color.BLACK);
    draw.circle(x, y, radius);
    // Draw children
    this.drawChildren(draw);
  }

  public void move(double xShift, double yShift) {
    this.x += xShift;
    this.y += yShift;
    // Move children
    this.moveChildren(xShift, yShift);
  }

  public void addChild(Drawable newPart) {
    this.bodyparts = Arrays.copyOf(this.bodyparts, this.bodyparts.length+1);
    this.bodyparts[this.bodyparts.length-1] = newPart;
  }

  private void drawChildren(Draw draw) {
    for (int i = 0; i < this.bodyparts.length; i++) {
      this.bodyparts[i].drawSelf(draw);
    }
  }
  
  private void moveChildren(double xShift, double yShift) {
    for (int i = 0; i < this.bodyparts.length; i++) {
      this.bodyparts[i].move(xShift, yShift);
    }
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double getRadius() {
    return this.radius;
  }
}
