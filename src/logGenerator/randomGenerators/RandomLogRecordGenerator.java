package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;

public class RandomLogRecordGenerator {
	private Random rnd;
	
	public RandomLogRecordGenerator(Random rnd){
		this.rnd = rnd;
	}
	
	public LogFileRecord generate(){
		LogFileRecord record = new LogFileRecord();
		
		record.setIpAddress(new RandomIpAdressGenerator().generate(rnd));
		record.setRequestTime(new RandomAccesTimeGenerator().generate(rnd));
		record.setRequestInfo(new RandomRequestInfoGenerator().generate(rnd));
		record.setBytesReturned(rnd.nextInt(Integer.MAX_VALUE));
		record.setStatusCode(new RandomHttpStatusCodeGenerator().generate(rnd));
		
		return record;
	}
}
