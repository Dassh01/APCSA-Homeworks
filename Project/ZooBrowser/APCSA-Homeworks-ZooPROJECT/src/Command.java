import java.util.ArrayList;

public class Command {
    private final String commandTASK;
    private final String commandPARAMETER;
    private final char delimiter = ':';
    public boolean cmdVALID = true;

    private final ArrayList<String> cmdParameterExceptions = new ArrayList<String>(); //consider replacing with a hashmap

    public Command(String commandAsString) {
        cmdParameterExceptions.add("help");
        cmdParameterExceptions.add("cmds");
        cmdParameterExceptions.add("shutdown");
        cmdParameterExceptions.add("end");
        cmdParameterExceptions.add("cmdhs");
        cmdParameterExceptions.add("commandhistory");
        cmdParameterExceptions.add("viewcommandhistory");
        cmdParameterExceptions.add("lsenc");
        cmdParameterExceptions.add("listenclosures");
        commandAsString = commandAsString.toLowerCase().trim();
        commandTASK = getStringBeforeDelimiter(commandAsString);
        commandPARAMETER = getStringAfterDelimiter(commandAsString);
    }

    public String getTask() {
        return commandTASK;
    }

    public String getParameter() {
        return commandPARAMETER;
    }

    public void displayCommand() {
        System.out.println("\nCommand task: " + getTask() +
                "\nCommand parameter: " + getParameter() +
                "\nCommand validity: " + cmdVALID +"\n");
    }

    private String getStringBeforeDelimiter(String input) {
        int index = input.indexOf(delimiter);
        if (index != -1) {
            return input.substring(0, index);
        }
        if (cmdParameterExceptions.contains(input)) {
            return input;
        }
        cmdVALID = false;
        return input;
    }

    private String getStringAfterDelimiter(String input) {
        int index = input.indexOf(delimiter);
        if (index != -1) {
            return input.substring(index+1);
        }
        if (cmdParameterExceptions.contains(input)) {
            return null;
        }
        cmdVALID = false;
        return null;
    }


}
