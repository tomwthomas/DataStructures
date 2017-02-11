/**
 * Created by tomwt_000 on 2/4/2017.
 * This class is used to read/write an instance of phone entry data
 */
public class PhoneEntry {
    private String firstName; // first name for this entry
    private String lastName; // last name for this entry
    private String emailAddress; // email address for this entry
    private String phoneNumber; // phone number for this entry

    public PhoneEntry() {
        this("", "", "", "");
    }

    public PhoneEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }

    public void printPhoneEntry() {
        System.out.println("first name: " + getFirstName() + ", last name: " + getLastName() + ", phone number: " + getPhoneNumber() + ", email: " + getEmailAddress());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
