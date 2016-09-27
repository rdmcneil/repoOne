package rdm.firstandroid;

import java.io.Serializable;

/**
 * Created by Owner on 9/27/2016.
 */
public class ContactInfo implements Serializable {
    private String name = "";
    private int phoneNumber;
    private String address = "";
    private String email = "";
    private String otherData = "";

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo(String name, String address, int phoneNumber, String email, String otherData ) {
        this.otherData = otherData;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String AltToString(){
        String out = "";
        out += name +"\n";
        out += phoneNumber +"\n";
        out += address +"\n";
        out += email +"\n";
        out += otherData +"\n";
        return out;
    }

    //This is a sample contact info for testing
    public void setToSample(){
        this.otherData = "Sample other data";
        this.email = "wob@rdm.com";
        this.address = "123 Some St";
        this.phoneNumber = 12345678;
        this.name = "Rob McNeil";
    }
}
