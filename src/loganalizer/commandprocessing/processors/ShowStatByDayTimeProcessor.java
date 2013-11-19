package loganalizer.commandprocessing.processors;

import java.util.HashMap;
import java.util.Map;
import loganalizer.RecordSetProcessor;
import loganalizer.commandprocessing.CommandResult;
import loganalizer.commandprocessing.UserCommandType;

public class ShowStatByDayTimeProcessor implements ICommandProcessor{
    private int morningStart = 6;
    private int dayTimeStart = 12;
    private int afternoonStart = 18;
    private int nightStart = 0;
    
    public int getMorningStart() {
        return morningStart;
    }

    public void setMorningStart(int morningStart) {
        this.morningStart = morningStart;
    }

    public int getDayTimeStart() {
        return dayTimeStart;
    }

    public void setDayTimeStart(int dayTimeStart) {
        this.dayTimeStart = dayTimeStart;
    }

    public int getAfternoonStart() {
        return afternoonStart;
    }

    public void setAfternoonStart(int afternoonStart) {
        this.afternoonStart = afternoonStart;
    }

    public int getNightStart() {
        return nightStart;
    }

    public void setNightStart(int nightStart) {
        this.nightStart = nightStart;
    }
    
    @Override
    public CommandResult process(RecordSetProcessor processor) {
        CommandResult result = new CommandResult();
        result.setCommand(UserCommandType.SHOW_REQUEST_BY_DAY_TIME_STATISTICS);
        Map<TimeOfDay, Integer> resultMap = new HashMap<TimeOfDay, Integer>();
        
        int reqCounter = 0;
        //Morning
        for(int i = morningStart; i < dayTimeStart; i++){
            reqCounter += processor.getRecordsByAccessHour(i).size();
        }
        resultMap.put(TimeOfDay.MORNING, new Integer(reqCounter));
        
        //Day time
        reqCounter = 0;
        for(int i = dayTimeStart; i < afternoonStart; i++){
            reqCounter += processor.getRecordsByAccessHour(i).size();
        }
        resultMap.put(TimeOfDay.DAYTIME, new Integer(reqCounter));
        
        //Afternoon
        reqCounter = 0;
        for(int i = afternoonStart; i < (nightStart < afternoonStart ? nightStart + 24 : nightStart); i++){
            if(i < 24)
                reqCounter += processor.getRecordsByAccessHour(i).size();
            else{
                reqCounter += processor.getRecordsByAccessHour(i - 24).size();
            }
        }
        resultMap.put(TimeOfDay.AFTERNOON, new Integer(reqCounter));
        
        //Night
        reqCounter = 0;
        for(int i = nightStart; i < (nightStart > morningStart ? morningStart + 24 : morningStart); i++){
            if(i < 24)
                reqCounter += processor.getRecordsByAccessHour(i).size();
            else{
                reqCounter += processor.getRecordsByAccessHour(i - 24).size();
            }
        }
        resultMap.put(TimeOfDay.NIGHT, new Integer(reqCounter));
        
        result.setResultMap(resultMap);
        
        return result;
    }
}
