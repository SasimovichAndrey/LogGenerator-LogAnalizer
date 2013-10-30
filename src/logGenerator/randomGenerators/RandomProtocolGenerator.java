package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.ProtocolType;

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
