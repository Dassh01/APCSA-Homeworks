import java.io.File;
import java.util.*;

public class Main extends beaUtils {

    private static Enclosure createEnclosure(Scanner scanner) {
        String enclosureName;
        String filePath;
        enclosureName = askForThing("Enter enclosure name: ", Scanner::nextLine, scanner);
        filePath = askForThing("Enter relative filepath (if none exist then enter -1): ", Scanner::nextLine, scanner);
        return new Enclosure(enclosureName,fetchTemp(),filePath);
    }

    private static Enclosure findEnclosureGivenEnclosureName(ArrayList<Enclosure> enclosures,String enclosureNameToLookFor) {
        for (Enclosure currentEnclosure : enclosures) {
            if (currentEnclosure.getEnclosureName().toLowerCase().equals(enclosureNameToLookFor)) {
                return currentEnclosure;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        //Initialization block
        Scanner scanner = new Scanner(System.in);
        boolean viewing = true;
        ArrayList<Enclosure> enclosures = new ArrayList<>();
        ArrayList<Command> commandHistory = new ArrayList<>();
        Enclosure cat_enclosure = new Enclosure("Cat",fetchTemp(),"cat.txt");
        Enclosure fox_enclosure = new Enclosure("Fox",fetchTemp(),"fox.txt");
        Enclosure hippo_enclosure = new Enclosure("Hippo",fetchTemp(),"hippo.txt");
        Enclosure kangaroo_enclosure = new Enclosure("Kangaroo",fetchTemp(),"kangaroo.txt");
        enclosures.add(cat_enclosure); enclosures.add(fox_enclosure); enclosures.add(hippo_enclosure); enclosures.add(kangaroo_enclosure);
        System.out.println("\nWelcome to our teleoperated zoo, if you're wondering why all of the enclosures have different temperatures it is because we gave all the animals thermostats C:\n" +
                "Type \"help\" to view a list of commands and usages");
        //Program loop
        String enclosureToLookAt;
        int amtEnclosures;
        boolean running = true;
        while(running) { //Making a while true loop that you can break out of from a switch case since break is a reserved switch case keyword
            Command currentCommand = new Command(askForThing("Enter command: ",Scanner::nextLine,scanner));

            commandHistory.add(currentCommand);

            if (!currentCommand.cmdVALID) {
                System.out.println("Please enter a valid command");
                continue;
            }

            switch (currentCommand.getTask()) {
                case "createenclosure":
                case "createenclosures":
                case "newenclosure":
                    try { //Prevent integer conversion errors
                        amtEnclosures = Integer.parseInt(currentCommand.getParameter());
                    } catch (Exception e) {
                        System.out.println("Please enter an integer parameter with this command");
                        continue;
                    }
                    for (int i = 0; i < amtEnclosures; ++i) {
                        enclosures.add(createEnclosure(scanner));
                    }
                    break;

                case "help":
                case "cmds":
                    System.out.println("""
                           \s
                            Commands:
                           \s
                            Command: createEnclosure : [Parameter of type integer]
                            Description: Creates an x amount of enclosures with x being the parameter of this command.
                            Will enter a deeper UI.
                           \s
                            Command: viewEnclosure : [Parameter of type String]                      \s
                            Description: Views the enclosure with the name of the provided parameter.
                            
                            Command: shutdown [NO PARAMETER]
                            Description: Ends the TUI
                            
                            Command: help [NO PARAMETER]
                            Description: Displays a list of applicable commands and descriptions
                            
                            Command: cmdHs [NO PARAMETER]
                            Description: Displays a list of formerly casted commands
                           \s""");
                    break;

                case "listenclosures":
                case "lsenc":
                    int i = 1;
                    for (Enclosure enclosure : enclosures) {
                        System.out.println(i + ")" + " " + enclosure.getEnclosureName());
                        ++i;
                    }
                    break;
                case "viewenclosure":
                    Enclosure focusedEnclosure = findEnclosureGivenEnclosureName(enclosures, currentCommand.getParameter());
                    if (focusedEnclosure == null) { //null check
                        System.out.println("Please look for a valid enclosure");
                        break;}
                    displayEnclosure(focusedEnclosure);
                    break;

                case "shutdown":
                case "end":
                    running = false;
                    break;

                case "commandhistory":
                case "viewcommandhistory":
                case "cmdhs":
                    System.out.println("Command History: ");
                    for (Command command : commandHistory) {
                        command.displayCommand();
                    }
                    break;

                default:
                    System.out.println("Command not recognized. Please type \"help\" to view a list of commands and usages.");
            }

        }
        System.out.println("Thank you for visiting the teleoperated zoo");
    }

    //Functions
    public static void displayEnclosure(Enclosure enclosure) //This function is responsible for displaying the animal img & stats
    {
        System.out.println("\n" +
                "Animal type: " +enclosure.getEnclosureName()+ //Pull animal name
                "\nCurrent time: "+fetchTime()+ //Get current time
                "\nHabitat temperature = "+ enclosure.getTemp()); //Pull enclosure temperature
        fetchAnimalIMG(enclosure.getFilepath()); //Display animal
        System.out.println(); //Move to next line
    }

    public static String fetchTime() //Grab and format current time
    {
        Calendar calendar = Calendar.getInstance(); //Create calender object

        calendar.getTime(); //Ask system what it thinks the time is
        String placeholder = ""; //Formatting string
        int minutes = calendar.get(Calendar.MINUTE); //Minutes represents minutes as a value
        if (minutes < 10) {
            placeholder = "0"; //Placeholder turns into a 0 to fill the gap so we don't get something like 2:5
        }
        int hours = calendar.get(Calendar.HOUR_OF_DAY); //Format to normal people time
        if (hours > 12) {
            hours = hours - 12; //No military time!
        }
        return(hours+":"+placeholder+minutes); //Return as a concise string (should look like 5:08)
    }

    public static double fetchTemp() //Generates a random temperature as a double to a million billion decimal places when called
    {
        int max = 100;
        int min = 50;
        Random rand = new Random();
        return rand.nextDouble(max - min + 1) + min; //Yeah im goanna be honest I took this from stackoverflow (https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range?)
    }

    public static void fetchAnimalIMG(String filepath) //Prints a ascii art from a txt file at filepath specified
    {
        if (filepath.equals("-1")) {
            System.out.println("No filepath provided");
            return;
        }
        File file = new File(filepath);
        try{
            Scanner fr = new Scanner(file);
            while(fr.hasNextLine()){
                String line = fr.nextLine();
                System.out.println(line);
            }
        } catch (Exception e){ //If it can't find a file at the provided file path
            System.out.println("No file");
        }
    }
}