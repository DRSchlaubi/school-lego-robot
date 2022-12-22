public class TableWalker {
    public static void main(String[] args) {
        TwoWheelRobot robot = new TwoWheelRobot();

        robot.drive();
        while (true) {
            if(DistanceUtil.fetchDistance(robot.getIrSensor()) <= 10) break;
        }
        robot.stop();
    }
}
