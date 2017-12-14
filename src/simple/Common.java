package simple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {
	private static  Map<String, ArrayList<String>> options = new HashMap<String, ArrayList<String>> ();
	public static  Map<String, ArrayList<String>> parseArguments(String [] args) {
		String option = null; 
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-") && args[i].length() > 1) {
				option = args[i].substring(1);
				options.put(option, new ArrayList<String>());
			} else if (option != null){
				options.get(option).add(args[i]);
			}
		}
		//System.out.println(options);		
		return options;
	}

	public List<String> getFileLines(String inputFilename) {
		List<String> lines = new ArrayList<String>();
		if (inputFilename != null && inputFilename.isEmpty() == false) {
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename), "Cp1252"));
				String line;
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
				br.close();
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         

		}
		return lines;
	}
	
	public List<String> getFilenames(String baseFolder, String filter) {
		File filesFolder = new File(baseFolder);
		List<String> fileNames = new ArrayList<String> ();
		if (filesFolder.exists() && filesFolder.isDirectory()) {
			FilenameFilter fileFilter = new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					if (filename.toLowerCase().endsWith(filter)) {
						return true;
					} else {
						return false;
					}
				}
			};
			
			File [] allFiles = filesFolder.listFiles(fileFilter);
			
			for (File file: allFiles) {
				if (file.isFile()) {
					fileNames.add(file.getName());
				}
			}
		}
		return fileNames;
	}


}
