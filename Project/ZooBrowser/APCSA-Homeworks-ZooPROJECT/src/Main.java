import java.io.File;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //Initialization block
        Scanner scanner = new Scanner(System.in);
        boolean viewing = true;

        Enclosure cat_enclosure = new Enclosure("Cat",fetchTemp(),"src/cat.txt");
        Enclosure fox_enclosure = new Enclosure("Fox",fetchTemp(),"src/fox.txt");
        Enclosure hippo_enclosure = new Enclosure("Hippo",fetchTemp(),"src/hippo.txt");
        Enclosure kangaroo_enclosure = new Enclosure("Kangaroo",fetchTemp(),"src/kangaroo.txt");

        System.out.println("Welcome to our teleoperated zoo, if you're wondering why all of the enclosures have different temperatures it's because we gave all the animals thermostats");
        //Program loop
        while(viewing) { //Making a while true loop that you can break out of from a switch case since break is a reserved switch case keyword
            System.out.println("""
                    Please enter the number of the habitat that you'd like to view: \

                    1 - Cat\

                    2 - Fox\

                    3 - Hippo\

                    4 - Kangaroo
                    Enter -1 if you'd like to exit
                    """);
            try { //Ensures that the user cannot error out the program with misinputs
                int inp = scanner.nextInt();
                switch (inp) {
                    case -1: //IF the user inputs this
                        viewing = false;
                        break;
                    case 1: //So on and so forth yk
                        displayEnclosure(cat_enclosure);
                        break;
                    case 2:
                        displayEnclosure(fox_enclosure);
                        break;
                    case 3:
                        displayEnclosure(hippo_enclosure);
                        break;
                    case 4:
                        displayEnclosure(kangaroo_enclosure);
                        break;
                    default: //If the user doesn't input any of the above
                        System.out.println("Camera not registered");
                }
            }
            catch(Exception e) {
                System.out.println("Camera not registered");
                scanner.next();
            }
        }
        System.out.println("Thank you for visiting the teleoperated zoo");
    }

    //Functions
    public static void displayEnclosure(Enclosure enclosure) //This function is responsible for displaying the animal img & stats
    {
        System.out.println("\n" +
                "Animal type: " +enclosure.getAnimal()+ //Pull animal name
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
        File file = new File(filepath);
        try{
            Scanner fr = new Scanner(file);
            while(fr.hasNextLine()){
                String i = fr.nextLine();
                System.out.println(i);
            }
        } catch (Exception e){ //If it can't find a file at the provided file path
            System.out.println("No file");
        }
    }
}