package logGenerator.logGenerating.recordformatting;

import logGenerator.logGenerating.logFileRecord.RequestInfo;

public class RequestInfoFormatter {
	public RequestInfoFormatter(){
		super();
	}
	
	public String format(RequestInfo reqInfo) throws IllegalArgumentException{
		if(reqInfo == null)
			throw new IllegalArgumentException("Null pointer : reqInfo");
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(new HttpRequestTypeFormatter().format(reqInfo.getRequestType()));
		builder.append(" ");
		builder.append(reqInfo.getRequestedSource());
		builder.append(" ");
		builder.append(new ProtocolTypeFormatter().format(reqInfo.getProtocol()));
		
		return builder.toString();
	}
}
