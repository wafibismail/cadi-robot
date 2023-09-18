import java.awt.Color;

public class LimbSegment extends DrawableRectangle{
  private LimbSegment nextSegment;
  private boolean isLeftLimb;
  protected boolean hasNextSegment;
  public LimbSegment(double x, double y, double h, double w, boolean isExtremity, boolean isLeftLimb) {
    super(x, y, h, w, Math.PI, isExtremity ? Color.GRAY : Color.CYAN);
    this.hasNextSegment = !isExtremity;
    this.isLeftLimb = isLeftLimb;
  }

  public LimbSegment(double x, double y, double radius, boolean isLeftLimb) {
    super(x, y, radius*2, radius*0.5, Math.PI, Color.CYAN);
    this.addForelimb();
    this.nextSegment.addExtremity();
    this.hasNextSegment = true;
    this.isLeftLimb = isLeftLimb;
  }

  private void addSegment(LimbSegment segment) {
    this.nextSegment = segment;
    addChild(segment);
  }

  private void addForelimb() {
    LimbSegment forelimb = new LimbSegment(this.getXEnd(), this.getYEnd(), this.getL(), this.getW(), false, this.isLeftLimb);
    this.addSegment(forelimb);
  }

  private void addExtremity() {
    LimbSegment extremity = new LimbSegment(this.getXEnd(), this.getYEnd(), this.getW()*1.5, this.getW()*1.5, true, this.isLeftLimb);
    this.addSegment(extremity);
  }
  
  public void rotate(double angle) {
    super.rotate(angle * (isLeftLimb ? -1 : 1));
    LimbSegment currentLimb = this;
    while(currentLimb.hasNextSegment) {
      currentLimb.nextSegment.setX(currentLimb.getXEnd());
      currentLimb.nextSegment.setY(currentLimb.getYEnd());
      currentLimb = currentLimb.nextSegment;
    }
  }

  public double getExtremityXEnd() {
    if (!this.hasNextSegment)
      return this.getXEnd();

    return this.nextSegment.getExtremityXEnd();
  }

  public double getExtremityYEnd() {
    if (!this.hasNextSegment)
      return this.getYEnd();

    return this.nextSegment.getExtremityYEnd();
  }
}
