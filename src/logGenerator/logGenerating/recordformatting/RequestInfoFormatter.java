package logGenerator.logGenerating.recordformatting;

import logGenerator.logGenerating.logFileRecord.RequestInfo;

public class RequestInfoFormatter {
	private String fieldSeparator = " ";
	
	public RequestInfoFormatter(){
		super();
	}
	
	public RequestInfoFormatter(String separator){
		this.fieldSeparator = separator;
	}
	
	public void setSeparator(String separator){
		this.fieldSeparator = separator;
	}
	
	public String getSeparator(){
		return fieldSeparator;
	}
	
	public String format(RequestInfo reqInfo) throws IllegalArgumentException{
		if(reqInfo == null)
			throw new IllegalArgumentException("Null pointer : reqInfo");
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(new HttpRequstTypeFormatter().format(reqInfo.getRequestType()));
		builder.append(fieldSeparator);
		builder.append(reqInfo.getRequestedSource());
		builder.append(fieldSeparator);
		builder.append(new ProtocolTypeFormatter().format(reqInfo.getProtocol()));
		builder.append(fieldSeparator);
		
		return builder.toString();
	}
}
