package gov.noaa.ims.nwsconnect.components.contactuploader.model;

import java.util.List;

import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;

public class Issue {
    private Contact contactInSystem;
    private ContactIssueType issueType;

    /**
     * This class is used to pass the cure details.
     * 
     * @param issueType The issue type
     */
    public Issue(ContactIssueType issueType) {
        this.issueType = issueType;
    }

    /**
     * This class is used to pass the cure details.
     * 
     * @param contactInSystem The contact in the system
     * @param issueType       The issue type
     */
    public Issue(Contact contactInSystem, ContactIssueType issueType) {
        this.contactInSystem = contactInSystem;
        this.issueType = issueType;
    }

    public Contact getContactInSystem() {
        return contactInSystem;
    }

    public void setContactInSystem(Contact contact) {
        this.contactInSystem = contact;
    }

    public ContactIssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(ContactIssueType issueType) {
        this.issueType = issueType;
    }

    public List<ContactIssueType.CureOption> getPossibleFixes() {
        return issueType.getCureOptions();
    }

}
