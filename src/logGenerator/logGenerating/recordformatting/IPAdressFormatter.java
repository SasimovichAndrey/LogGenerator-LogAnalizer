package logGenerator.logGenerating.recordformatting;

import logGenerator.logGenerating.logFileRecord.IpAddress;

public class IPAdressFormatter {
	public String format(IpAddress ipadress) throws FormatException{
		if(ipadress == null){
			throw new FormatException("Null pointer: ipadress", new NullPointerException());
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < ipadress.getOctetCount(); i++){
			builder.append(ipadress.getOctet(i));
			builder.append('.');
		}
		
		return builder.toString(); 
	}
}
