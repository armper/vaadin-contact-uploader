package gov.noaa.ims.nwsconnect.components;

import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.ContactUploader;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactList;
import gov.noaa.ims.nwsconnect.components.service.ContactCureServiceMock;

@Route("")
@SpringComponent
@UIScope
public class MainView extends VerticalLayout {

    private final ContactUploader contactUploader;
    private final ContactCureServiceMock cureServiceMock;

    public MainView(ContactUploader contactUploader, ContactCureServiceMock cureServiceMock) {
        this.contactUploader = contactUploader;
        this.cureServiceMock = cureServiceMock;

        setupContactUploader();
        add(contactUploader);

    }

    private void setupContactUploader() {

        contactUploader.setService(cureServiceMock);
        

    }

}