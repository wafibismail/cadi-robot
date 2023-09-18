public class HeadTorso extends Head {
  private Torso torso;
  public HeadTorso (double x, double y, double radius) {
    super(x, y, radius);

    torso = new Torso(x, y-radius, radius);
    
    addChild(torso);
  }

  protected double [] getTorsoXCoords() {
    return torso.getXCoords();
  }

  protected double [] getTorsoYCoords() {
    return torso.getYCoords();
  }

  public boolean isTorsoTouched(double x, double y) {
    return torso.isTouched(x, y);
  }

  public boolean isTorsoHTouched(double x) {
    return torso.isHTouched(x);
  }

  public boolean isTorsoVTouched(double y) {
    return torso.isVTouched(y);
  }
  
}
