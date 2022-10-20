import lejos.hardware.port.Port;

@SuppressWarnings("FieldCanBeLocal")
public class TwoWheelRobot {
	private final EV3Brick brick = new EV3Brick();
	private final double speed = 1.0;
	private final Motor motA = new Motor();
	private final Motor motB = new Motor();
	private final Port portA = brick.getPort("A");
	private final Port portB = brick.getPort("B");

	public TwoWheelRobot() {
		motA.connect(portA);
		motB.connect(portB);
	}

	void drive() {
		motA.start(speed);
	}
}
