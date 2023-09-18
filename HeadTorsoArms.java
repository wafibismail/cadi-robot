public class HeadTorsoArms extends HeadTorso{
  private LimbSegment lArm, rArm;
  public HeadTorsoArms(double x, double y, double radius) {
    super(x, y, radius);
    double [] xCoords = this.torso.getXCoords();
    double [] yCoords = this.torso.getYCoords();
    rArm = new LimbSegment(xCoords[0], yCoords[0], radius, false);
    lArm = new LimbSegment(xCoords[1], yCoords[1], radius, true);
    addChild(rArm);
    addChild(lArm);
  }

  public LimbSegment getArm(int index) {
    return index == 0 ? lArm : rArm;
  }
}
