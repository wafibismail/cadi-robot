public class HeadTorso extends Head {
  protected Torso torso;
  public HeadTorso (double x, double y, double radius) {
    super(x, y, radius);
    this.torso = new Torso(x, y-radius, radius);
    this.addChild(torso);
  }

  public boolean isTorsoTouched(double x, double y) {
    return this.torso.isTouched(x, y);
  }

  public boolean isTorsoHTouched(double x) {
    return this.torso.isHTouched(x);
  }

  public boolean isTorsoVTouched(double y) {
    return this.torso.isVTouched(y);
  }
  
}
