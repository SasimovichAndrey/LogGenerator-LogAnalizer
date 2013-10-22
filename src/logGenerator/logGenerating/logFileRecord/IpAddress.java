package logGenerator.logGenerating.logFileRecord;

import logGenerator.exceptions.IllegalValueException;

public class IpAddress {
	private short [] octets = {0, 0, 0, 0};
	
	public void setOctet(int index, short value) throws IllegalValueException, IndexOutOfBoundsException{
		if(index < 0 || index > 3){
			throw new IndexOutOfBoundsException();
		}
		if(value < 0 || value > 255){
			throw new IllegalValueException();
		}
		octets[index] = value;
	}
	
	public short getOctet(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > 3)
			throw new IndexOutOfBoundsException();
		return octets[index];
	}
	
	public String toString(){
		return Short.toString(octets[0]) + '.' + Short.toString(octets[1]) + '.' + Short.toString(octets[2]) + '.' + Short.toString(octets[3]);
	}
}
