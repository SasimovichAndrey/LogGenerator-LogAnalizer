package loganalizer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import logGenerator.logFileRecord.LogFileRecord;
import logGenerator.logFileRecord.StatusCode;

public class RecordSetProcessor {
    private final List<LogFileRecord> records;
    
    public RecordSetProcessor(List<LogFileRecord> records){
        this.records = records;
    }
    
    public List<StatusCode> getStatuses(){
        List<StatusCode> statuses = new ArrayList<StatusCode>();
        
        for(LogFileRecord record : records){
            StatusCode code = record.getStatusCode();
            if(!statuses.contains(code))
                statuses.add(code);
        }
        
        return statuses;
    }
    
    public List<LogFileRecord> getRecordsByStatusCode(StatusCode code){
        List<LogFileRecord> resRecords = new ArrayList<LogFileRecord>();
        
        for(LogFileRecord record : records){
            if(record.getStatusCode().equals(code)){
                resRecords.add(record);
            }
        }
        
        return resRecords;
    }
    
    public List<LogFileRecord> getRecordsByAccessHour(int hour){
        List<LogFileRecord> resRecords = new ArrayList<LogFileRecord>();
        
        Date reqTime = null;
        GregorianCalendar calendar = new GregorianCalendar(Locale.ENGLISH);
        for(LogFileRecord record : records){
            reqTime = record.getRequestTime();
            calendar.setTime(reqTime);
            if(calendar.get(Calendar.HOUR_OF_DAY) == hour)
                resRecords.add(record);
        }
        
        return resRecords;
    }
}
