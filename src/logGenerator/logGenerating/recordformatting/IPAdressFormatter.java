package logGenerator.logGenerating.recordformatting;

import logGenerator.logGenerating.logFileRecord.IpAddress;

public class IPAdressFormatter {
	public String format(IpAddress ipadress) throws IllegalArgumentException{
		if(ipadress == null){
			throw new IllegalArgumentException("Null pointer: ipadress");
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < ipadress.getOctetCount(); i++){
			builder.append(ipadress.getOctet(i));
                        if(i != ipadress.getOctetCount() - 1)
                            builder.append('.');
		}
		
		return builder.toString(); 
	}
}
