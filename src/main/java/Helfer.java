import lejos.utility.Delay;


public class Helfer {
    public static final double DURCHMESSER = 5.6;
    public static final double SPURWEITE = 11.7;

    private Helfer() {
    }

    public static void delayProgramm(double sek) {
        Delay.msDelay((int) (sek * 1000));
    }

    public static double getUmdrehungen(double cm) {
        return cm / (DURCHMESSER * Math.PI);
    }

    public static double circleSegmentDistance(double degrees) {
        return (SPURWEITE * Math.PI * degrees) / 180;
    }

    public static void runMotorForDegrees(Motor motor, double degrees) {
        runMotorForDegrees(motor, 0.5, degrees);
    }

    public static void runMotorForDegrees(Motor motor, double speed, double degrees) {
        double distance = circleSegmentDistance(degrees);
        double rotations = getUmdrehungen(distance);
        double seconds = rotations / speed;

        motor.start(speed);
        delayProgramm(seconds);
        motor.stop();
    }
}