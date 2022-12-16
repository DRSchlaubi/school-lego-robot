import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public class Motor {
	private EV3LargeRegulatedMotor mot;
	public void connect(Port port) {
		mot = new EV3LargeRegulatedMotor(port);
	}
	public void start(double speed) {
		if(speed >= 0){
			mot.setSpeed((int)(speed*360));
			mot.forward();
		}
		else {
			mot.setSpeed((int)(-speed*360));
			mot.backward();
		}			
	}
	public void stop() {
		mot.stop(true);
	}
}
