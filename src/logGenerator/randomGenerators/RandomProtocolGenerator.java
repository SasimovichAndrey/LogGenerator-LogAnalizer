package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.ProtocolType;

public class RandomProtocolGenerator {
	public ProtocolType generate(Random rnd){
		int rndIndex = rnd.nextInt(ProtocolType.values().length);
		return ProtocolType.values()[rndIndex];
	}
}
