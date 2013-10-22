package logGenerator.logGenerating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.randomGenerators.RandomLogRecordGenerator;
import logGenerator.requestProcessing.exceptions.RequestFormatException;

public class LogFileDataSetGenerator {
	public List<LogFileRecord> generate(int count) throws RequestFormatException{
		if(count <= 0)
			throw new RequestFormatException();
		
		Random rnd = new Random();
		RandomLogRecordGenerator recGenerator = new RandomLogRecordGenerator(rnd);
		List<LogFileRecord> recordList = new ArrayList<LogFileRecord>();
		
		
		for(int i = 0; i < count; i++){
			recordList.add(recGenerator.generate());
		}
		
		return recordList;
	}
}
