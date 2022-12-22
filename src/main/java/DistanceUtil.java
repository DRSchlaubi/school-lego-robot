import lejos.hardware.sensor.EV3IRSensor;

public class DistanceUtil {
    public static float fetchDistance(EV3IRSensor sensor) {
        float[] sample = new float[sensor.getDistanceMode().sampleSize()];
        sensor.getDistanceMode().fetchSample(sample, 0);

        return sample[0];
    }
}
