import lejos.utility.Delay;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        TwoWheelRobot robo = new TwoWheelRobot();
        robo.drive(5);
        Delay.msDelay(TimeUnit.SECONDS.toMillis(2));
        robo.setSpeed(-1);
        robo.drive(5);
    }
}
