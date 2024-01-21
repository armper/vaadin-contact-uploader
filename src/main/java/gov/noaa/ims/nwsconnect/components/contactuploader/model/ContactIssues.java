package gov.noaa.ims.nwsconnect.components.contactuploader.model;

import java.util.List;

public class ContactIssues {
    ContactDTO contactToBeImported;

    private List<Issue> issues;

    public ContactIssues(ContactDTO contactToBeImported, List<Issue> issues) {
        this.contactToBeImported = contactToBeImported;
        this.issues = issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public void remove(Issue issue) {
        this.issues.remove(issue);
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public ContactDTO getContactToBeImported() {
        return contactToBeImported;
    }

    public void setContactToBeImported(ContactDTO contactToBeImported) {
        this.contactToBeImported = contactToBeImported;
    }

}
