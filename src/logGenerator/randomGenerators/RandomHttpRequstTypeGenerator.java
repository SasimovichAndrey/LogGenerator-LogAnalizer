package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.HttpRequestType;

public class RandomHttpRequstTypeGenerator {
	private Random rnd;
	
	public RandomHttpRequstTypeGenerator(Random rnd) {
		super();
		this.rnd = rnd;
	}

	public HttpRequestType generate(){
		int rndVal = rnd.nextInt(2);	
		if(rndVal == 0)
			return HttpRequestType.GET;
		else
			return HttpRequestType.POST;
	}
	
	public HttpRequestType generate90(){
		ProbabyilityGenerator probGen = new ProbabyilityGenerator(rnd);
		HttpRequestType [] arr = new HttpRequestType[2];
		arr[0]=HttpRequestType.POST;
		arr[1]=HttpRequestType.GET;
		int [] arr2 = new int[2];
		arr2[0] = 1;
		arr2[1] = 9;
		HttpRequestType retType =(HttpRequestType)probGen.generate(arr, arr2); 
		return retType;
	}
}
