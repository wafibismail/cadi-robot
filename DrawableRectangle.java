import java.awt.Color;
import java.util.Arrays;

public abstract class DrawableRectangle implements Drawable {
  private double x, y, l, w, rotation;
  private Color fillColor;
  private Drawable [] bodyparts = {};

  public DrawableRectangle(double x, double y, double l, double w, double rotation, Color fillColor) {
    this.x = x;
    this.y = y;
    this.l = l;
    this.w = w;
    this.rotation = rotation;
    this.fillColor = fillColor;
  }

  protected double [] getXCoords() {
    return new double [] {
      x + Math.cos(rotation)*-w/2,
      x + Math.cos(rotation)*w/2,
      x + Math.cos(rotation)*w/2 - Math.sin(rotation)*l,
      x + Math.cos(rotation)*-w/2 - Math.sin(rotation)*l
    };
  }

  protected double [] getYCoords() {
    return new double [] {
      y + Math.sin(rotation)*-w/2,
      y + Math.sin(rotation)*w/2,
      y + Math.sin(rotation)*w/2 + Math.cos(rotation)*l,
      y + Math.sin(rotation)*-w/2 + Math.cos(rotation)*l
    };
  }

  public void rotate(double angle) {
    rotation += angle;
    rotation %= (2*Math.PI);
  }
  public double getRotation() {
    return rotation;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getXEnd() {
    return x - Math.sin(rotation)*l;
  }

  public double getYEnd() {
    return y + Math.cos(rotation)*l;
  }

  public double getW() {
    return w;
  }

  public double getL() {
    return l;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void drawSelf(Draw draw) {
    // Draw fill
    draw.setPenColor(this.fillColor);
    draw.filledPolygon(this.getXCoords(), this.getYCoords());
    // Draw outline
    draw.setPenColor(Color.BLACK);
    draw.polygon(this.getXCoords(), this.getYCoords());
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
}
