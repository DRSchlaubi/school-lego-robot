public class TableWalker {

    private final TwoWheelRobot robot = new TwoWheelRobot();

    private TableWalker() {
    }

    public static void main(String[] args) {
        new TableWalker().loop(0);
    }

    private void loop(int i) {
        robot.setSpeed(1);
        robot.drive();
        while (true) {
            if (DistanceUtil.fetchDistance(robot.getIrSensor()) <= 10) break;
        }
        robot.stop();
        robot.setSpeed(-1);
        robot.driveDist(10);
        robot.stop();
        robot.turn(Direction.RIGHT, 90);
        if (i < 4) {
            loop(i + 1);
        }
    }
}
