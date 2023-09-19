public class Speech implements Drawable {
  private String speechText = "";
  private double x, y;

  public Speech(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void drawSelf(Draw draw) {
    draw.text(x, y, speechText);
  }

  public void move(double xShift, double yShift) {
    this.x += xShift;
    this.y += yShift;
  }

  public void changeText(String newText) {
    speechText = newText;
  }
}
