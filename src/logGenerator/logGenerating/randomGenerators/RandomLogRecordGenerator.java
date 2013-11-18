package logGenerator.logGenerating.randomGenerators;

import java.util.Random;

import logGenerator.logFileRecord.LogFileRecord;

public class RandomLogRecordGenerator {
	private Random rnd;
	
	public RandomLogRecordGenerator(Random rnd){
		this.rnd = rnd;
	}
	
	public LogFileRecord generate(){
		LogFileRecord record = new LogFileRecord();
		
		record.setIpAddress(new RandomIpAdressGenerator(rnd).generate());
		record.setRequestTime(new RandomAccesTimeGenerator(rnd).generate());
		record.setRequestInfo(new RandomRequestInfoGenerator(rnd).generate());
		record.setBytesReturned(rnd.nextInt(Integer.MAX_VALUE));
		record.setStatusCode(new RandomHttpStatusCodeGenerator(rnd).generate());
		
		return record;
	}
}
