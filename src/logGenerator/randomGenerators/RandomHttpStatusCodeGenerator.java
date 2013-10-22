package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.StatusCode;

public class RandomHttpStatusCodeGenerator {
	public StatusCode generate(Random rnd){
		int rndIndex = rnd.nextInt(StatusCode.values().length);
		return StatusCode.values()[rndIndex];
	}
}
