package logGenerator.logGenerating.logFileRecord;

public class RequestInfo {
	private HttpRequestType requestType;
	private String requestedSource;
	private ProtocolType protocol;

	public HttpRequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(HttpRequestType requestType) {
		this.requestType = requestType;
	}
	public String getRequestedSource() {
		return requestedSource;
	}
	public void setRequestedSource(String requestedSource) {
		this.requestedSource = requestedSource;
	}
	public ProtocolType getProtocol() {
		return protocol;
	}
	public void setProtocol(ProtocolType protocol) {
		this.protocol = protocol;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		if(requestType == HttpRequestType.GET)
			builder.append("GET");
		else
			builder.append("POST");
		builder.append(" " + requestedSource);
		builder.append(" " + protocol.getProtocolString());
		
		return builder.toString();
	}
        
        public boolean equals(Object obj){
            if(obj instanceof RequestInfo == false) return false;
            RequestInfo ri = (RequestInfo)obj;
            if(!(this.protocol == null ? ri.protocol == null : this.protocol.equals(ri.protocol)))return false;
            if(!(this.requestType == null ? ri.requestType == null : this.requestType.equals(ri.requestType))) return false;
            if(!(this.requestedSource == null ? ri.requestedSource == null : this.requestedSource.equals(ri.requestedSource))) return false;
            
            return true;
        }
}
