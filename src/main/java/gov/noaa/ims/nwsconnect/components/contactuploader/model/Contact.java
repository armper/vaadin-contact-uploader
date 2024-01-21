package gov.noaa.ims.nwsconnect.components.contactuploader.model;

public class Contact {
    private String firstName;
    private String lastName;
    private String primaryEmailAddress;
    private String primaryPhone;
    private String nwsOfficeId;

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

    public String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    public void setPrimaryEmailAddress(String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getNwsOfficeId() {
        return nwsOfficeId;
    }

    public void setNwsOfficeId(String nwsOfficeId) {
        this.nwsOfficeId = nwsOfficeId;
    }

    public String getPrimaryEmailAddressString() {
        return primaryEmailAddress;
    }

    public String getPrimaryPhoneString() {
        return primaryPhone;
    }

}
