package gov.noaa.ims.nwsconnect.components.contactuploader;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;

@UIScope
@SpringComponent
public class FlaggedContactsListComponent extends VerticalLayout {

    private final ApplicationContext applicationContext;

    public FlaggedContactsListComponent(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void setContacts(List<ContactIssues> contacts) {
        removeAll();
        
        contacts.stream().forEach(contact -> {
            FlaggedContactComponent flaggedContactComponent = applicationContext.getBean(FlaggedContactComponent.class);
            flaggedContactComponent.setContact(contact);
            add(flaggedContactComponent);
        });
    }

}
