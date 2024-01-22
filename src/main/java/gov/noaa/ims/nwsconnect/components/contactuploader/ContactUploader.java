package gov.noaa.ims.nwsconnect.components.contactuploader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.events.ContactListUploadedEvent;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactList;
import gov.noaa.ims.nwsconnect.components.service.ContactIssueProcessor;

@UIScope
@SpringComponent
public class ContactUploader extends VerticalLayout {

    private ContactUploadComponent contactUploadComponent;

    private ProcessingIndicatorComponent processingIndicatorComponent;

    private final FlaggedContactsListComponent flaggedContactsListComponent;

    private ContactIssueProcessor contactIssueProcessor;

    public ContactUploader(FlaggedContactsListComponent flaggedContactsListComponent) {
        this.flaggedContactsListComponent = flaggedContactsListComponent;

        setupComponents();
        addComponents();

        // don't make width full
        setWidth(null);
    }

    private void setupComponents() {
        // Initialize components

        contactUploadComponent = new ContactUploadComponent();
        processingIndicatorComponent = new ProcessingIndicatorComponent();

        configureUploadComponent();

    }

    private void addComponents() {
        add(contactUploadComponent, processingIndicatorComponent, flaggedContactsListComponent);
    }

    private void configureUploadComponent() {
        contactUploadComponent.addFileUploadedListener(event -> {
            processingIndicatorComponent.startProcessing();

            try (InputStream inputStream = event.getFileContent()) {
                ObjectMapper objectMapper = new ObjectMapper();
                List<ContactDTO> contacts = objectMapper.readValue(inputStream, new TypeReference<List<ContactDTO>>() {
                });
                ContactList contactList = new ContactList();
                contactList.setContacts(contacts);

                List<ContactIssues> contactIssueList = contactIssueProcessor.processContacts(contactList);

                setContactIssues(contactIssueList);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setContactIssues(List<ContactIssues> contacts) {
        flaggedContactsListComponent.setContacts(contacts);
    }

    public Registration addContactListUploadedListener(ComponentEventListener<ContactListUploadedEvent> listener) {
        return addListener(ContactListUploadedEvent.class, listener);
    }

    /**
     * Sets the service to be used to process contacts.
     * 
     * @param contactProcesses
     */
    public void setService(ContactIssueProcessor contactProcesses) {
        this.contactIssueProcessor = contactProcesses;
    }

}
