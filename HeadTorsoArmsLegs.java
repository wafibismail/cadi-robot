public class HeadTorsoArmsLegs extends HeadTorsoArms{
  private LimbSegment lLeg, rLeg;
  public HeadTorsoArmsLegs(double x, double y, double radius) {
    super(x, y, radius);
    double [] xCoords = this.torso.getXCoords();
    double [] yCoords = this.torso.getYCoords();
    rLeg = new LimbSegment(xCoords[2], yCoords[2], radius, false);
    lLeg = new LimbSegment(xCoords[3], yCoords[3], radius, true);
    addChild(rLeg);
    addChild(lLeg);
  }

  public LimbSegment getLeg(int index) {
    return index == 0 ? lLeg : rLeg;
  }
}
