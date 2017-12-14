package simple;

import java.util.ArrayList;

public class Command {
	private String command;
	private ArrayList<String> parameters = new ArrayList<String>();
	
	public Command(String commandLine) {
		String [] commandAndParameters = commandLine.split(" ");
		if (commandAndParameters.length > 1) {
			command = commandAndParameters[0];
			for (int i = 1; i < commandAndParameters.length; i++) {
				if (commandAndParameters[i].isEmpty() == false) {
					parameters.add(commandAndParameters[i]);
				}
			}
			System.out.println(this.toJsonString());
		}
	}
	
	public String getCommand() {
		return command;
	}
	
	public ArrayList<String> getParameters() {
		return parameters;
	}
	
	public String toString() {
		return command + ": " + parameters;
	}
	public String toJsonString() {
		return "{\"" + command + "\": [\"" + String.join("\", \"", parameters) + "\"]}";
	}

}
