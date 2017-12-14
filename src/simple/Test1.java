package simple;

import java.io.File;

public class Test1 extends Common{
	private static String folder = System.getenv("HOME");
	public static void main(String [] args) {
		parseArguments(args);
		ReadJsonFiles readJsonFiles = new ReadJsonFiles(folder);
		DatFile datFile = new DatFile(System.getProperty("user.dir") + File.separator + "program.dat");
		System.out.println(readJsonFiles.getFilenames("/Users/yannbertaud/Downloads", "json"));
		System.out.println(datFile.getCommands());
		
	}
	
}
