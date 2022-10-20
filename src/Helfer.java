import lejos.utility.Delay;


public class Helfer {
	public static final double DURCHMESSER = 5.6;
	public static final double SPURWEITE = 11.7;
	private Helfer(){}
	public static void delayProgramm(double sek) {
		Delay.msDelay((int)(sek*1000));
	}
	public static double getUmdrehungen(double cm) {
		return cm/(DURCHMESSER*Math.PI);
	}
}