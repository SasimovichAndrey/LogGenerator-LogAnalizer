package logGenerator.logGenerating.randomGenerators;

import java.util.Random;

import logGenerator.exceptions.IllegalValueException;
import logGenerator.logFileRecord.IpAddress;

public class RandomIpAdressGenerator {
	private Random rnd;
	
	public RandomIpAdressGenerator(Random rnd) {
		super();
		this.rnd = rnd;
	}

	public IpAddress generate(){
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
