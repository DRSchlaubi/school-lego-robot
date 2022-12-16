import lejos.hardware.port.Port;
import lejos.utility.Delay;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("FieldCanBeLocal")
public class TwoWheelRobot {
	private final EV3Brick brick = new EV3Brick();
	private double speed = 1.0;
	private final Motor motA = new Motor();
	private final Motor motB = new Motor();
	private final Port portA = brick.getPort("A");
	private final Port portB = brick.getPort("B");

	public TwoWheelRobot() {
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
	
}
