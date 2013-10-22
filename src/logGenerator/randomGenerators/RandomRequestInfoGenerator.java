package logGenerator.randomGenerators;

import java.util.Random;

import logGenerator.logGenerating.logFileRecord.RequestInfo;
import logGenerator.randomGenerators.RandomHttpRequstTypeGenerator;

public class RandomRequestInfoGenerator {
	public RequestInfo generate(Random rnd){
		RequestInfo reqInfo = new RequestInfo();
		
		reqInfo.setProtocol(new RandomProtocolGenerator().generate(rnd));
		String [] fileNameArr = new String[]{"/index.html", "/guest.html", "/contacts.html"};
		reqInfo.setRequestedSource((String)new ProbabyilityGenerator().generate(fileNameArr, rnd));
		reqInfo.setRequestType(new RandomHttpRequstTypeGenerator().generate(rnd)); 
		
		return reqInfo;
	}
}
