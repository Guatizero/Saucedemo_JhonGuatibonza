package models;

public class CheckoutData {
    private String firstname;
    private String lastname;
    private String postalcode;

    public CheckoutData(String firstname, String lastname, String postalcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.postalcode = postalcode;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getPostalcode() { return postalcode; }
}

