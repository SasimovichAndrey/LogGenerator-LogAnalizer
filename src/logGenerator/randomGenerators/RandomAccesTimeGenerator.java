package logGenerator.randomGenerators;

import java.util.Date;
import java.util.Random;

public class RandomAccesTimeGenerator {
	public Date generate(Random rnd, Date startDate){
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
	
	public Date generate(Random rnd){
		Date curDate = new Date();
		Date minDate = new Date(0);
		
		int rndYear = rnd.nextInt(curDate.getYear() - minDate.getYear()) + minDate.getYear();
		int rndMonth = rnd.nextInt(curDate.getMonth());
		int rndDay = rnd.nextInt(curDate.getDay());
		int rndHour = rnd.nextInt(curDate.getHours());
		int rndMin = rnd.nextInt(curDate.getMinutes());
		int rndSeconds = rnd.nextInt(curDate.getSeconds());
				
		Date rndDate = new Date(rndYear, rndMonth, rndDay, rndHour, rndMin, rndSeconds);
		
		return rndDate;
	}
}
