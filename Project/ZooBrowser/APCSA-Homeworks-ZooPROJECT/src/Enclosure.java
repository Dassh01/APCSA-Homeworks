public class Enclosure {
    private final String enclosureName; //Class attributes
    private final String temperature;
    private final String filepath;

    public Enclosure(String name,double temp,String inpFilepath) {
        enclosureName = name; //Constructor parameter
        temperature = String.format("%.4g%n",temp);
        filepath = inpFilepath;
    }

    public String getEnclosureName() {
        return enclosureName;
    }

    public String getTemp() {
        return temperature;
    }

    public String getFilepath() {
        return filepath;
    }
}
