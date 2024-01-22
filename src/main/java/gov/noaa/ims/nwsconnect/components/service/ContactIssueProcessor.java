package gov.noaa.ims.nwsconnect.components.service;

import java.util.List;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactList;

public interface ContactIssueProcessor {
    public List<ContactIssues> processContacts(ContactList contactList);
}
