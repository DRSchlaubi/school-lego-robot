import lejos.hardware.Brick;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;


public class EV3Brick {
	private Brick brick;
	
	public EV3Brick() {
		brick = LocalEV3.get();
	}
	
	public Port getPort(String portName) {
		return brick.getPort(portName);
	}	
}
