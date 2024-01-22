package gov.noaa.ims.nwsconnect.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.MergeContactsDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@Route("merge-contacts-test-view")
@SpringComponent
@UIScope
public class MergeContactsTestView extends VerticalLayout {

    public MergeContactsTestView(MergeContactsDialog mergeContactsDialog) {

        ContactIssueType issueType = ContactIssueType.EMAIL_ADDRESS_EXISTS_SAME_OFFICE;

        CureDetails details = new CureDetails(issueType, getContactDTO(), getContactInSystem());
        mergeContactsDialog.showDialog(details, a -> {
            System.out.println("Merged contact result: " + a);
        });
    }

    private ContactDTO getContactInSystem() {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName("Jane");
        contactDTO.setLastName("Smith");
        contactDTO.setEmailType1("Work");
        contactDTO.setEmailAddress1("jane.smith@work.com");
        contactDTO.setEmailType2("Personal");
        contactDTO.setEmailAddress2("j.smith@personal.com");
        contactDTO.setEmailType3("Other");
        contactDTO.setEmailAddress3("j.smith@other.com");

        contactDTO.setPhoneType1("Mobile");
        contactDTO.setPhoneNumber1(2225554321L);
        contactDTO.setPhoneExtension1("123");
        contactDTO.setPhoneSms1(true);
        contactDTO.setPhoneType2("Home");
        contactDTO.setPhoneNumber2(2225556789L);
        contactDTO.setPhoneExtension2("456");
        contactDTO.setPhoneSms2(false);
        contactDTO.setPhoneType3("Work");
        contactDTO.setPhoneNumber3(2225559876L);
        contactDTO.setPhoneExtension3("789");
        contactDTO.setPhoneSms3(true);

        contactDTO.setAddressType1("Home");
        contactDTO.setAddressFieldA1("123 Main St");
        contactDTO.setAddressFieldB1("Unit 101");
        contactDTO.setAddressCity1("Metropolis");
        contactDTO.setAddressState1("NY");
        contactDTO.setAddressPostalCode1("12345");
        contactDTO.setAddressCountry1("USA");
        contactDTO.setAddressCounty1("Metro County");

        contactDTO.setAddressType2("Work");
        contactDTO.setAddressFieldA2("456 Second St");
        contactDTO.setAddressFieldB2("Suite 202");
        contactDTO.setAddressCity2("Gotham");
        contactDTO.setAddressState2("NJ");
        contactDTO.setAddressPostalCode2("54321");
        contactDTO.setAddressCountry2("USA");
        contactDTO.setAddressCounty2("Gotham County");

        return contactDTO;
    }

    private ContactDTO getContactDTO() {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName("Jane");
        contactDTO.setLastName("Doe");
        contactDTO.setEmailType1("Primary");
        contactDTO.setEmailAddress1("jane.doe@primary.com");
        contactDTO.setEmailType2("Secondary");
        contactDTO.setEmailAddress2("jane.doe@secondary.com");
        contactDTO.setEmailType3("Other");
        contactDTO.setEmailAddress3("jane.doe@other.com");

        contactDTO.setPhoneType1("Mobile");
        contactDTO.setPhoneNumber1(7775551123L);
        contactDTO.setPhoneExtension1("321");
        contactDTO.setPhoneSms1(true);
        contactDTO.setPhoneType2("Home");
        contactDTO.setPhoneNumber2(7775552234L);
        contactDTO.setPhoneExtension2("654");
        contactDTO.setPhoneSms2(false);
        contactDTO.setPhoneType3("Work");
        contactDTO.setPhoneNumber3(7775553345L);
        contactDTO.setPhoneExtension3("987");
        contactDTO.setPhoneSms3(true);

        contactDTO.setAddressType1("Office");
        contactDTO.setAddressFieldA1("789 Third Ave");
        contactDTO.setAddressFieldB1("Floor 3");
        contactDTO.setAddressCity1("Star City");
        contactDTO.setAddressState1("CA");
        contactDTO.setAddressPostalCode1("67890");
        contactDTO.setAddressCountry1("USA");
        contactDTO.setAddressCounty1("Star County");

        return contactDTO;
    }
}
