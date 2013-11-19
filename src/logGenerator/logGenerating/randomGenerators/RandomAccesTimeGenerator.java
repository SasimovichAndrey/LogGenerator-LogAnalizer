package logGenerator.logGenerating.randomGenerators;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomAccesTimeGenerator {
	private Random rnd;
        private int minYear = 2000;
	
	public RandomAccesTimeGenerator(Random rnd) {
		super();
		this.rnd = rnd;
	}

	public Date generate(Date startDate){
		Date curDate = new Date();
		Date minDate = startDate;
		
		int rndYear = rnd.nextInt(curDate.getYear() - minDate.getYear()) + minDate.getYear();
		int rndMonth = rnd.nextInt(curDate.getMonth());
		int rndDay = rnd.nextInt(curDate.getDay());
		int rndHour = rnd.nextInt(curDate.getHours());
		int rndMin = rnd.nextInt(curDate.getMinutes());
		int rndSeconds = rnd.nextInt(curDate.getSeconds());
				
		Date rndDate = new Date(rndYear, rndMonth, rndDay, rndHour, rndMin, rndSeconds);
		
		return rndDate;
	}
	
	public Date generate(){
		Date curDate = new Date();
		Date minDate = new Date(0);
		
                GregorianCalendar calendar = new GregorianCalendar();
                
                
		int rndYear = rnd.nextInt(calendar.get(Calendar.YEAR) - minYear);
                calendar.set(Calendar.YEAR, rndYear + minYear);
		int rndMonth = rnd.nextInt(12);
                calendar.set(Calendar.MONTH, rndMonth);
		int rndDay = rnd.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.DAY_OF_MONTH, rndDay);
		int rndHour = rnd.nextInt(24);
                calendar.set(Calendar.HOUR_OF_DAY, rndHour);
		int rndMin = rnd.nextInt(60);
                calendar.set(Calendar.MINUTE, rndMin);
		int rndSeconds = rnd.nextInt(60);
                calendar.set(Calendar.SECOND, rndSeconds);
                calendar.set(Calendar.MILLISECOND, 0);
                
		Date rndDate = calendar.getTime();
		
		return rndDate;
	}
}
