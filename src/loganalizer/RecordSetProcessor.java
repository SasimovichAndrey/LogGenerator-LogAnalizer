package loganalizer;

import java.io.File;
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
    
    private String getFileExtension(String fileName){
        String [] splited = fileName.split("\\.");
        if(splited.length != 1)
            return splited[splited.length - 1];
        else
            return null;
    }
    
    public List<String> getFileTypes(){
        List<String> types = new ArrayList<String>();
        
        for(LogFileRecord record : records){
            String path = record.getRequestInfo().getRequestedSource();
            File sourceFile = new File(path);
            String ext = getFileExtension(sourceFile.getName());
            if(ext != null && !types.contains(ext))
                types.add(ext);
        }
        
        return types;
    }
    
    public List<LogFileRecord> getRecordsByFileExtension(String extension){
        List<LogFileRecord> resRecords = new ArrayList<LogFileRecord>();
        
        for(LogFileRecord record : records){
            String path = record.getRequestInfo().getRequestedSource();
            File sourceFile = new File(path);
            String ext = getFileExtension(sourceFile.getName());
            if(extension.equals(ext))
                resRecords.add(record);
        }
        
        return resRecords;
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
