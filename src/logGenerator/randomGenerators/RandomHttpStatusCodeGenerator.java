package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.StatusCode;

public class RandomHttpStatusCodeGenerator {
	private Random rnd;
	
	public RandomHttpStatusCodeGenerator(Random rnd) {
		super();
		this.rnd = rnd;
	}



	public StatusCode generate(){
		int rndIndex = rnd.nextInt(StatusCode.values().length);
		return StatusCode.values()[rndIndex];
	}
}
