package logGenerator.logFileRecord;

import java.util.Date;



public class LogFileRecord {
	private IpAddress ipAddress;
	private Date requestTime;
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
	public void setRequestTime(Date requestTime) {
            requestTime.setTime(requestTime.getTime() - requestTime.getTime() % 1000); // Отсечение секунд и милисекунд
            this.requestTime = requestTime;
	}
	
	public Date getRequestTime(){
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
        
        @Override
        public boolean equals(Object obj){
            if(obj instanceof LogFileRecord == false) return false;
            LogFileRecord lr = (LogFileRecord)obj;
            
            if(!(this.ipAddress == null ? lr.ipAddress == null : this.ipAddress.equals(lr.ipAddress))) return false;
            if(!(this.requestTime == null ? lr.requestTime == null : this.requestTime.equals(lr.requestTime))) return false;
            if(!(this.requestInfo == null ? lr.requestInfo == null : this.requestInfo.equals(lr.requestInfo))) return false;
            if(!(this.statusCode == null ? lr.statusCode == null : this.statusCode.equals(lr.statusCode))) return false;
            if(!(this.bytesReturned == lr.bytesReturned)) return false;
            
            return true;
        }
}
