package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies;

import org.springframework.stereotype.Component;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.Contact;

@Component
public class SessionCache {

    public Contact getSessionUser() {
        Contact user = new Contact();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setNwsOfficeId("ABQ");

        return user;
    }

}
