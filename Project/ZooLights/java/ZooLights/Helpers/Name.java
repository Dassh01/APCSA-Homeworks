package ZooLights.Helpers;

public class Name {
    String firstname;
    String lastname;

    public Name (String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Name () {}

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
