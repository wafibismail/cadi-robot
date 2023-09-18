import java.awt.Color;

public class RobotClient implements DrawListener {
    private Draw draw = new Draw();
    private Basin basin;
    private CompleteRobot robot;
    /* private boolean isNormalWalking = true; */

    public RobotClient() {
        int n = 10;
        draw.addListener(this);
        draw.setXscale(0, n);
        draw.setYscale(0, n);

        // draw black grid lines with gray background
        draw.clear(Color.LIGHT_GRAY);
        draw.setPenColor(Color.BLACK);
        basin = new Basin(n/2, 0.75, 1);
        basin.drawSelf(draw);
        robot = new CompleteRobot(n/4, 0, 0.25);
        robot.act();
        robot.changeAction(new ActionSquat(robot));
        robot.drawSelf(draw);
        basin.drawTopLayer(draw);
        draw.show();
    }

    public void mousePressed(double x, double y) {
        String speechText = "I am doing nothing!";
        if (basin.isTouched(x, y)) {
            if (basin.waterIsHTouched(robot.getArm(0).getX()-0.25)
                && basin.waterIsHTouched(robot.getArm(1).getX()+0.25)) {
                robot.act(Direction.DOWN);
                speechText = "I am soaking my hands";
            } else if (basin.getX() < robot.getX()) {
                robot.toLeft();
                speechText = "I am moving left, to the water basin";
            } else {
                robot.toRight();
                speechText = "I am moving right, to the water basin";
            }
        } else if(robot.isTorsoHTouched(x)) {
        //} else if(robot.isTorsoTouched(x, y)) {
            robot.act();
            speechText = "I am squatting";
        } else /* if(!robot.isTorsoHTouched(x)) */ {
            if(x < robot.getX()) {
                robot.toLeft();
                speechText = "I am moving left";
            }
            else {
                robot.toRight();
                speechText = "I am moving right";
            }
        }
        /* else {
            if (isNormalWalking) {
                speechText = speechText + " I just switched to squat-walking!";
                isNormalWalking = false;
                robot.changeMoveAction(new ActionSquat(robot));
            } else {
                speechText = speechText + " I am switching to normal walking!";
                isNormalWalking = true;
                robot.changeMoveAction(new ActionStep(robot));

            }
        } */

        draw.clear(Color.LIGHT_GRAY);
        robot.drawSelf(draw);
        robot.say(draw, speechText);
        basin.drawSelf(draw);
        robot.getArm(0).drawSelf(draw);
        robot.getArm(1).drawSelf(draw);
        basin.drawTopLayer(draw);
        draw.show();
    }

    // test client
    public static void main(String[] args) {
        new RobotClient();
    }

}