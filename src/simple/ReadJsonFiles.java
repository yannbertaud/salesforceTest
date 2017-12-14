package simple;

import java.util.List;

public class ReadJsonFiles extends Common{
	private String baseFolder; 
	public ReadJsonFiles(String folder) {
		baseFolder = folder;
	}
	
	public List<String> getFilenames() {
		return getFilenames(baseFolder, "json");
	}
}
