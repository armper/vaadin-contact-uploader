package gov.noaa.ims.nwsconnect.components.contactuploader.events;

import com.vaadin.flow.component.ComponentEvent;

import gov.noaa.ims.nwsconnect.components.contactuploader.ContactUploader;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactList;

public class ContactListProcessedEvent extends ComponentEvent<ContactUploader> {
    private final ContactList contactList;

    public ContactListProcessedEvent(ContactUploader source, ContactList contactList) {
        super(source, false);
        this.contactList = contactList;
    }

    public ContactList getContactList() {
        return contactList;
    }
}
