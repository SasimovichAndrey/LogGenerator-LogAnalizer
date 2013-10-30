package logGenerator.randomGenerators;

import java.util.Random;

public class ProbabyilityGenerator {
	private Random rnd;
	
	public ProbabyilityGenerator(Random rnd){
		this.rnd = rnd;
	}
	
	public Object generate(Object[] objArr){
		int rand = rnd.nextInt(objArr.length);
		return objArr[rand];
	}
	public Object generate(Object[] objArr, int[] probArr){
		int sum = 0;
		for(int i = 0; i < probArr.length; i++){
			sum += probArr[i];
		}
		
		int rndIndex = rnd.nextInt(sum);
		
		int nextSum, prevSum = 0;
		int resIndex = 0;
		for(int i = 0; i < probArr.length; i++){
			nextSum = prevSum + probArr[i];
			if(rndIndex >= prevSum && rndIndex < nextSum){
				resIndex = i;
				return objArr[resIndex];
			}
			prevSum += probArr[i];
		}
		
		return null;
	}
}
