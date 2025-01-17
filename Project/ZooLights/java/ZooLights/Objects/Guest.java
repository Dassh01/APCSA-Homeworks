package ZooLights.Objects;

import ZooLights.Helpers.Name;

public class Guest {

    private final Date birthday;
    private final Date today;
    private final Name name;
    private final boolean isRidingTrain;
    private final double height;
    private final double weight;
    private final boolean canRideTrain;

    public Guest(Date birthday, Name name, boolean isRidingTrain, double height, double weight, Date today) {
        this.birthday = birthday;
        this.name = name;
        this.isRidingTrain = isRidingTrain;
        this.height = height;
        this.weight = weight;
        this.today = today;
        this.canRideTrain = weight < 300 && height > 48;
    }

    public boolean eligibleToRideTrain() {
        return canRideTrain;
    }
    public Date getBirthday() {
        return birthday;
    }

    public boolean isRidingTrain() {
        return isRidingTrain;
    }

    public int getAge() {
        return today.getYear() - birthday.getYear();
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name.getFirstname() + " " + name.getLastname();
    }

}