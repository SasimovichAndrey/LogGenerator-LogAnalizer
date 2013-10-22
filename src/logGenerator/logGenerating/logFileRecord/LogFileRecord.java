package logGenerator.logGenerating.logFileRecord;



public class LogFileRecord {
	private IpAddress ipAddress;
	private RequestTime requestTime;
	private RequestInfo requestInfo;
	private StatusCode statusCode;
	private int bytesReturned;

	//Getters and setters
	
	public IpAddress getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	public void setRequestTime(RequestTime requestTime) {
		this.requestTime = requestTime;
	}
	
	public RequestTime getRequestTime(){
		return this.requestTime;
	}
	
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public StatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(StatusCode statusCode){
		this.statusCode = statusCode;
	}
	public int getBytesReturned() {
		return bytesReturned;
	}
	public void setBytesReturned(int bytesReturned) throws IllegalArgumentException{
		if(bytesReturned < 0)
			throw new IllegalArgumentException();
		this.bytesReturned = bytesReturned;
	}
}
