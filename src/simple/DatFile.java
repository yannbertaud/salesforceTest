package simple;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatFile extends Common{
	private String inputFilename;
	private List<String> lines;
	public String getInputFilename() {
		return inputFilename;
	}
	public DatFile(String inputFilename) {
		this.inputFilename = inputFilename;
		this.lines = getFileLines(this.inputFilename);
	}
	public ArrayList<Command> getCommands() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (String line: this.lines) {
			commands.add(new Command(line));
		}
		
		return commands;
	}
	public Map<String, ArrayList<String>> getKeyValues() {
		Map<String, ArrayList<String>> keyValues = new HashMap<String, ArrayList<String>>();
		for(String line : lines) {
			String [] wordsPerLine = line.split(" ");
			System.out.println(line);
			if (wordsPerLine.length > 1) {
				ArrayList<String> parameters = new ArrayList<String> ();
				for (int i = 1; i < wordsPerLine.length; i++) {
					if (wordsPerLine[i].isEmpty() == false) {
						parameters.add(wordsPerLine[i]);
					}
				}
				keyValues.put(wordsPerLine[0], parameters);
			}
		}
		return keyValues;
	}
	public List<String> getLines() {
		return lines;
	}
}
