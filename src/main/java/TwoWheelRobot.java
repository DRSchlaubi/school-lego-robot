import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("FieldCanBeLocal")
public class TwoWheelRobot {
    private final EV3Brick brick = new EV3Brick();
    private double speed;
    private final Motor motA = new Motor();
    private final Motor motB = new Motor();
    private final Port portA = brick.getPort("A");
    private final Port portB = brick.getPort("B");
    private final Port port1 = brick.getPort("S1");
    private final EV3IRSensor irSensor = new EV3IRSensor(port1);

    public TwoWheelRobot() {
        this(5);
    }

    public TwoWheelRobot(int speed) {
        this.speed = speed;
        motA.connect(portA);
        motB.connect(portB);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    void drive() {
        motA.start(speed);
        motB.start(speed);
    }

    void drive(int seconds) {
        drive((long) seconds);
    }

    void drive(long seconds) {
        drive();
        Delay.msDelay(TimeUnit.SECONDS.toMillis(seconds));
        stop();
    }

    void stop() {
        motA.stop();
        motB.stop();
    }

    void turn() {
        motA.start(speed);
    }

    void shitCode() {
        drive();
        brick.getBrick().getLED().setPattern(1);
        brick.getBrick().getAudio().setVolume(100);
        brick.getBrick().getAudio().systemSound(2);
        Helfer.delayProgramm(3);
        brick.getBrick().getLED().setPattern(3);
        brick.getBrick().getAudio().systemSound(3);
        Helfer.delayProgramm(3);
        brick.getBrick().getLED().setPattern(5);
        brick.getBrick().getAudio().systemSound(4);
    }

    public void turn(Direction direction, double degrees) {
        Motor motor;
        if (direction == Direction.LEFT) {
            motor = motB;
        } else {
            motor = motA;
        }
        Helfer.runMotorForDegrees(motor, degrees);
    }

    public EV3IRSensor getIrSensor() {
        return irSensor;
    }

    public void driveDist(int distance) {
        double rotations = Helfer.getUmdrehungen(distance) / speed;
        drive();
        Delay.msDelay((int) ((rotations / speed) * 1000.0));
        stop();
    }

    public void drivePolygon(int polys, int length) {
        int angle = 90;
        for (int i = 0; i < polys; i++) {
            driveDist(length);
            Helfer.runMotorForDegrees(motA, speed, angle);
        }
    }
}
