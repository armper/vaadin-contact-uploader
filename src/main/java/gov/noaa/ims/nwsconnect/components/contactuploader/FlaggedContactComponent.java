package gov.noaa.ims.nwsconnect.components.contactuploader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.AddToCurrentOfficeDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.MergeContactsDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.NoaaLinkDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces.IssueDialogStrategy;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;
import gov.noaa.ims.nwsconnect.components.contactuploader.events.CureAppliedEvent;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.Issue;

@CssImport("./styles/info-card.css")
@Scope("prototype")
@SpringComponent
public class FlaggedContactComponent extends VerticalLayout {

    private final Map<ContactIssueType, IssueDialogStrategy> dialogStrategies = new HashMap<>();

    private final Map<Issue, ContactResolutionComponent> issueComponentMap = new HashMap<>();

    private final ApplicationEventPublisher eventPublisher;

    private ContactIssues contactIssues;

    public FlaggedContactComponent(
            ApplicationEventPublisher eventPublisher,
            AddToCurrentOfficeDialog addToCurrentOfficeDialog,
            MergeContactsDialog mergeContactsDialog,
            NoaaLinkDialog noaaLinkDialog) {
        this.eventPublisher = eventPublisher;

        dialogStrategies.put(ContactIssueType.PHONE_NUMBER_EXISTS_OTHER_OFFICE,
                addToCurrentOfficeDialog);

        dialogStrategies.put(ContactIssueType.PHONE_NUMBER_EXISTS_SAME_OFFICE,
                mergeContactsDialog);

        dialogStrategies.put(ContactIssueType.EMAIL_ADDRESS_EXISTS_OTHER_OFFICE,
                addToCurrentOfficeDialog);

        dialogStrategies.put(ContactIssueType.EMAIL_ADDRESS_EXISTS_SAME_OFFICE,
                mergeContactsDialog);

        dialogStrategies.put(ContactIssueType.IS_NOAA_EMAIL_ADDRESS,
                noaaLinkDialog);

    }

    private void buildLayout() {
        addClassName("info-card");

        add(new Label("Name: " + contactIssues.getContactToBeImported().getFirstName() + " "
                + contactIssues.getContactToBeImported().getLastName()));
        add(new Label("Email: " + contactIssues.getContactToBeImported().getEmailAddress1()));

        List<Issue> issues = contactIssues.getIssues();
        for (int i = 0; i < issues.size(); i++) {
            Issue issue = issues.get(i);
            ContactResolutionComponent resolutionComponent = new ContactResolutionComponent();

            add(new Label("Issue: " + issue.getIssueType().getDescription()));

            resolutionComponent.getResolveButton().addClickListener(listener -> {
                showDialog(issue);
            });

            addResolutionComponent(resolutionComponent, issue);

            if (issues.size() > 1 && i < issues.size() - 1) {
                add(new Hr());
            }
        }
    }

    private void addResolutionComponent(ContactResolutionComponent resolutionComponent, Issue issue) {
        add(resolutionComponent);
        issueComponentMap.put(issue, resolutionComponent);
    }

    private void showDialog(Issue issue) {
        CureDetails details = new CureDetails(issue.getIssueType(),
                contactIssues.getContactToBeImported(), issue.getContactInSystem());

        // Use the selected issue to retrieve the correct dialog strategy
        IssueDialogStrategy dialogStrategy = dialogStrategies.get(details.getIssueType());
        if (dialogStrategy != null) {
            dialogStrategy.showDialog(details, updatedDetails -> fireEvent(updatedDetails, issue));
        } else {
            fireEvent(details, issue); // Directly fire event if no dialog is needed
        }
    }

    private void fireEvent(CureDetails details, Issue issue) {
        eventPublisher.publishEvent(new CureAppliedEvent(this, details));

        ContactResolutionComponent resolvedComponent = issueComponentMap.get(issue);
        if (resolvedComponent != null) {
            resolvedComponent.markAsResolved();
        }
    }

    public void setContact(ContactIssues contactIssues) {
        this.contactIssues = contactIssues;

        removeAll();

        buildLayout();
    }

}
