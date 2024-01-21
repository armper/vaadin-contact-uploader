package gov.noaa.ims.nwsconnect.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.MergeContactsDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.Contact;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@Route("merge-contacts-test-view")
@SpringComponent
@UIScope
public class MergeContactsTestView extends VerticalLayout {

    private final MergeContactsDialog mergeContactsDialog;

    public MergeContactsTestView(MergeContactsDialog mergeContactsDialog) {
        this.mergeContactsDialog = mergeContactsDialog;

        ContactIssueType issueType = ContactIssueType.EMAIL_ADDRESS_EXISTS_SAME_OFFICE;

        CureDetails details = new CureDetails(issueType, getContactDTO(), getContactInSystem());
        mergeContactsDialog.showDialog(details, a -> {
            System.out.println("a");
        });
    }

    private Contact getContactInSystem() {
        Contact contact = new Contact();
        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPrimaryEmailAddress("jane@doe.com");
        contact.setPrimaryPhone("555-555-1234");
        contact.setNwsOfficeId("ABQ");
        return contact;
    }

    private ContactDTO getContactDTO() {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName("Jane");
        contactDTO.setLastName("Doe");
        contactDTO.setEmailAddress1("jane@doe.com");
        contactDTO.setPhoneNumber1(7775551123L);
        return contactDTO;
    }

}