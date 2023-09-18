import java.awt.Color;

public class RobotClient implements DrawListener {
    private Draw draw = new Draw();
    private CompleteRobot robot;
    private boolean isNormalWalking = true;

    public RobotClient() {
        int n = 10;
        draw.addListener(this);
        draw.setXscale(0, n);
        draw.setYscale(0, n);

        // draw black grid lines with gray background
        draw.clear(Color.LIGHT_GRAY);
        draw.setPenColor(Color.BLACK);
        robot = new CompleteRobot(n/2, 0, 0.25);
        robot.act();
        robot.changeAction(new ActionSquat(robot));
        robot.drawSelf(draw);
        draw.show();
    }

    public void mousePressed(double x, double y) {
        String speechText = "I am doing nothing!";
        if(robot.isTorsoTouched(x, y)) {
            robot.act();
            speechText = "I am squatting";
        } else if(!robot.isTorsoHTouched(x)) {
            if(x < robot.getX()) {
                robot.toLeft();
                speechText = "I am moving left";
            }
            else {
                robot.toRight();
                speechText = "I am moving right";
            }
        }
        else {
            if (isNormalWalking) {
                speechText = speechText + " I just switched to squat-walking!";
                isNormalWalking = false;
                robot.changeMoveAction(new ActionSquat(robot));
            } else {
                speechText = speechText + " I am switching to normal walking!";
                isNormalWalking = true;
                robot.changeMoveAction(new ActionStep(robot));

            }
        }

        draw.clear(Color.LIGHT_GRAY);
        robot.drawSelf(draw);
        robot.say(draw, speechText);
        draw.show();
    }

    // test client
    public static void main(String[] args) {
        new RobotClient();
    }

}