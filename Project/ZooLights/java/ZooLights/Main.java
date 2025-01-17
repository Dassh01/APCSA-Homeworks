package ZooLights;

import ZooLights.Helpers.Utils;
import ZooLights.Objects.Date;
import ZooLights.Objects.Party;
import ZooLights.Objects.TicketGroup;

import java.util.ArrayList;
import java.util.Scanner;

/*
Name: Luke Tye, Jack Fryer, Henry Felsted, Beatrice Gilfix
Date: 12/17/24
Assignment: Zoo Lights Ticket Generator
 */

public class Main extends Utils {

    public static boolean debug = false;

    /**
     * @param scanner - Gets input from user
     * @param currentDate - Gets the current date and prints it out
     * @param parties - Gets the amount and data of the current party
     * @param ticketGroups - Combines party, type of ticket, and party name
     */
    public static void runTUI (Scanner scanner, Date currentDate, ArrayList <Party> parties, ArrayList <TicketGroup> ticketGroups){
        //initializing variables used in the interface
        String command;
        boolean running = true;
        while (running) {
            command = askForThing("> ", Scanner::nextLine, scanner, true);

            /* console commands by using a switch case
            If it matches the string in the case it is a valid command, and it will run the code */ //what??
            switch (sanitize(command)) {
                case ("generateparty"):
                    parties.add(generateParty(scanner, currentDate));
                    break;

                case ("listparties"):
                case ("ls:p"):
                    displayParties(parties);
                    break;

                case ("help"):
                case ("cmds"):
                    System.out.print("""
                        ------------------------- Commands -------------------------
                        Functions: Generate party, End, Compile Ticket Group
                        Viewing: List parties, Lookat : party, Lookat : ticketindex, Lookat : ticketgroup, Lookat : ticket, ls
                        Debug: debug, Current date, gendefaultparty
                        Misc: Cmds/Help, Version
                        """ );
                    break;

                case ("end"):
                    System.out.println("\nGoodbye " + System.getProperty("user.name"));
                    running = false;
                    break;

                case ("debug"):
                    debug = !debug;
                    System.out.println("Debug: (" + !debug + ")" + " -> " + "(" + debug + ")");
                    break;

                case ("currentdate"):
                    System.out.println(currentDate.getDateAsString());
                    break;

                case ("version"):
                case ("ver"):
                    System.out.println(Utils.dasshTag);
                    break;

                case ("lookat:party"):
                    lookatParty(scanner, parties);
                    break;

                case ("generatedefaultparty"):
                case ("gendefaultparty"):
                case ("gdp"):
                    if (debug) {
                        parties.add(getDefaultParty()); //For testing!
                    }
                    else {
                        System.out.println("Please enable debug mode to access this function");
                    }
                    break;

                case ("compileticketgroup"):
                case ("ctg"):
                    compileTicketGroup(scanner, parties, ticketGroups);
                    break;

                case ("lookat:ticketindex"):
                case ("ls:t"):
                    displayTicketGroups(ticketGroups);
                    break;
                case("ls"):
                    displayParties(parties);
                    displayTicketGroups(ticketGroups);
                    break;
                case ("clear"):
                case ("clr"):
                    clearTerminal();
                    break;
                case ("lookat:ticketgroup"):
                case ("ls:tg"):
                    lookatTicketGroup(scanner, ticketGroups);
                    break;
                //TODO: Decorate ticket output
                case ("lookat:ticket"):
                case ("ls:tt"):
                    lookForTicket(scanner, ticketGroups);
                    break;
                default:
                    System.out.println("Command not recognized");
            }

        }
    }

    //TODO: Separate useful and "redundant" comments
    //TODO: Leave formatting to Jack & Henry?
    //starting the system up
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        Date currentDate = getCurrentDate();
        ArrayList<Party> parties = new ArrayList<>();
        ArrayList<TicketGroup> ticketGroups = new ArrayList<>();
        startingSequence();
        System.out.println("Welcome to the ZooLights Ticket Maker System, User " + System.getProperty("user.name"));
        //runs the terminal user interface
        runTUI(scanner, currentDate, parties, ticketGroups);
    }
}