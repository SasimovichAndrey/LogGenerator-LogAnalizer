package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.exceptions.IllegalValueException;
import logGenerator.logGenerating.logFileRecord.IpAddress;

public class RandomIpAdressGenerator {
	
	public IpAddress generate(Random rnd){
		IpAddress ipAdress = new IpAddress();
		
		try {
			ipAdress.setOctet(0, (short)rnd.nextInt(128));
			ipAdress.setOctet(1, (short)rnd.nextInt(256));
			ipAdress.setOctet(2, (short)rnd.nextInt(256));
			ipAdress.setOctet(3, (short)rnd.nextInt(256));
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ipAdress;
	}
}
