public class Test3 {
    public static void main(String[] args) {
        TwoWheelRobot robi = new TwoWheelRobot();
        robi.setSpeed(0.5);
        for (int i = 0; i < 4; i++) {
            robi.drive((int) (Helfer.getUmdrehungen(50) / 0.5));
            robi.turn(Direction.RIGHT, 90);
        }
    }
}
