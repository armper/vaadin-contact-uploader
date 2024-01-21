package gov.noaa.ims.nwsconnect.components.contactuploader.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType.CureOption;

public class CureDetails {
    private final ContactIssueType issueType;
    private final ContactDTO contactToBeImported;
    private final Contact contactInSystem;

    private CureOption selectedCure;

    private ContactDTO userMergedContact;

    /**
     * This class is used to pass the cure details.
     * 
     * @param issueType           The issue type
     * @param contactToBeImported The contact to be imported
     * @param contactInSystem     The contact in the system
     * 
     */
    public CureDetails(ContactIssueType issueType, ContactDTO contactToBeImported,
            Contact contactInSystem) {
        this.issueType = issueType;
        this.contactToBeImported = contactToBeImported;
        this.contactInSystem = contactInSystem;

    }

    public ContactIssueType getIssueType() {
        return issueType;
    }

    public void setUserMergedContact(ContactDTO payload) {
        this.userMergedContact = payload;
    }

    public ContactDTO getUserMergedContact() {
        return userMergedContact;
    }

    public ContactDTO getContactToBeImported() {
        return contactToBeImported;
    }

    public Contact getContactInSystem() {
        return contactInSystem;
    }

    public CureOption getSelectedCure() {
        return selectedCure;
    }

    public void setSelectedCure(CureOption selectedCure) {
        this.selectedCure = selectedCure;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
