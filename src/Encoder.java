import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Encoder {

	public static void main(String[] args) {
		File file = new File("PinkPanther30.wav");
		
		try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))) {
			byte[] bytes = reader.readNBytes(Integer.MAX_VALUE);
			
			String enc = new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
			System.err.println(enc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
