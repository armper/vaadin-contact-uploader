package gov.noaa.ims.nwsconnect.components.contactuploader.model;

import java.util.List;

public class ContactList {
    private List<ContactDTO> contacts;

    public ContactList() {
    }

    public ContactList(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return contacts.size() + " contacts";
    }

}
