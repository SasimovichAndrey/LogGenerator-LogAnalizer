package logGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import logGenerator.logGenerating.AccessLog;
import logGenerator.logGenerating.LogFileDataSetGenerator;
import logGenerator.logGenerating.logFileRecord.LogFileRecord;
import logGenerator.requestProcessing.RequestParser;
import logGenerator.requestProcessing.exceptions.RequestFormatException;

public class Program {
	private static String getFileDirectory(String path){
		String filePath;
		try{
			filePath = path.substring(0, path.lastIndexOf("/") + 1);
			return filePath;
		}
		catch(StringIndexOutOfBoundsException e){
			return "";
		}
	}
	
	// Получение имени файла из строки пути
	private static String getFileName(String path){
		String fileName;
		try{
			fileName = path.substring(path.lastIndexOf("/") + 1);
			return fileName;
		}
		catch(StringIndexOutOfBoundsException e){
			return "";
		}
	}
	
	public static void main(String [] args){
		RequestParser parser = new RequestParser();
		HashMap<String, String> request = parser.parse(args);
		TextInterface txtInterface = new TextInterface();

		List<LogFileRecord> recordList;
		AccessLog logFile;
		PrintWriter writer = null;
		
		String filePath = getFileDirectory(request.get(ProgramParamConstants.FILE_NAME_PARAM));
		String fileName = getFileName(request.get(ProgramParamConstants.FILE_NAME_PARAM));
		if(new File(filePath).exists() == false){
			filePath = "";
		}
		
		Integer strCount = null;
		LogFileDataSetGenerator dataSetGenerator = new LogFileDataSetGenerator();
		try{
			strCount = Integer.parseInt(request.get(ProgramParamConstants.STR_COUNT_PARAM));
			recordList = dataSetGenerator.generate(strCount);		// Генерация записей лог-файла
			
			logFile = new AccessLog(recordList); 
			writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath + fileName) ));

			logFile.SaveToTxt(writer);		// Запись текста в файл
			
			txtInterface.printSuccess(filePath + fileName);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid request format");
		}
		catch(RequestFormatException e){
			System.out.println("Invalid request format");
		}
		catch(IOException e){
			System.out.println("IOException");
		}
		finally{
			if(writer != null)
				writer.close();
		}
	}
}
