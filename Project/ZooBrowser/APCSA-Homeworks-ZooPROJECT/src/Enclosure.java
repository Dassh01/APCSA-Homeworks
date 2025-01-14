public class Enclosure {
    private String animal; //Class attributes
    private String temperature;
    private String filepath;

    public Enclosure(String name,double temp,String inpFilepath) { //Is this a constructor
        animal = name; //Constructor parameter
        temperature = String.format("%.4g%n",temp);
        filepath = inpFilepath;
    }

    public String getAnimal() {
        return animal;
    }

    public String getTemp() {
        return temperature;
    }

    public String getFilepath() {
        return filepath;
    }
}
