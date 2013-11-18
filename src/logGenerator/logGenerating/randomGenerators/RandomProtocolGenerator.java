package logGenerator.logGenerating.randomGenerators;

import java.util.Random;

import logGenerator.logFileRecord.ProtocolType;

public class RandomProtocolGenerator {
	private Random rnd;
	
	public RandomProtocolGenerator(Random rnd) {
		super();
		this.rnd = rnd;
	}

	public ProtocolType generate(){
		int rndIndex = rnd.nextInt(ProtocolType.values().length);
		return ProtocolType.values()[rndIndex];
	}
}
