package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components.ContactInfoLayout;
import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces.BaseDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType.CureOption;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.Contact;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@UIScope
@Component
public class MergeContactsDialog extends BaseDialog {

        private RadioButtonGroup<MergeOption> options;

        private final SessionCache sessionCache;

        private ContactDTO userMergedContact;

        private ContactInfoLayout contactInSystemViewer;

        private ContactInfoLayout contactToBeImportedViewer;

        public MergeContactsDialog(SessionCache sessionCache) {
                this.sessionCache = sessionCache;
        }

        @Override
        protected void buildDialogLayout(Dialog dialog, CureDetails details, Consumer<CureDetails> onApply) {
                contactInSystemViewer = new ContactInfoLayout();
                contactToBeImportedViewer = new ContactInfoLayout();

                contactInSystemViewer.setContact(details.getContactInSystem().getFirstName(),
                                details.getContactInSystem().getLastName(),
                                details.getContactInSystem().getPrimaryEmailAddressString(),
                                details.getContactInSystem().getPrimaryPhoneString(),
                                details.getContactInSystem().getNwsOfficeId());
                contactToBeImportedViewer.setContact(details.getContactToBeImported().getFirstName(),
                                details.getContactToBeImported().getLastName(),
                                details.getContactToBeImported().getEmailAddress1(),
                                longToPhoneNumberString(details.getContactToBeImported().getPhoneNumber1()),
                                sessionCache.getSessionUser().getNwsOfficeId());

                contactInSystemViewer.setCheckboxChangeListener(this::updateMergedContact);
                contactToBeImportedViewer.setCheckboxChangeListener(this::updateMergedContact);

                options = new RadioButtonGroup<>();
                options.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
                options.setItems(MergeOption.values());
                options.setItemLabelGenerator(MergeOption::toString);

                options.addValueChangeListener(event -> handleMergeOptionChange(event.getValue(), details));

                dialog.add(new VerticalLayout(
                                contactToBeImportedViewer,
                                contactInSystemViewer,
                                options));

                H3 warningHeader = new H3(
                                "Merge the contacts for the following contact in the "
                                                + details.getContactInSystem().getNwsOfficeId() + " office.");
                dialog.add(new VerticalLayout(
                                warningHeader,
                                new H4("Contact To Be Imported:"),
                                contactToBeImportedViewer,
                                new H4("Contact In the System:"),
                                contactInSystemViewer,
                                options));
        }

        private void updateMergedContact() {
                // Implement logic to update userMergedContact based on checkbox states
                // Example:
                ContactDTO contactInSystem = contactInSystemViewer.getSelectedContactData();
                ContactDTO contactToBeImported = contactToBeImportedViewer.getSelectedContactData();

                userMergedContact = new ContactDTO();
                userMergedContact.setFirstName(
                                contactInSystemViewer.getNameCheckbox().getValue() ? contactInSystem.getFirstName()
                                                : contactToBeImported.getFirstName());
                userMergedContact.setLastName(
                                contactInSystemViewer.getNameCheckbox().getValue() ? contactInSystem.getLastName()
                                                : contactToBeImported.getLastName());
                userMergedContact.setEmailAddress1(
                                contactInSystemViewer.getEmailCheckbox().getValue() ? contactInSystem.getEmailAddress1()
                                                : contactToBeImported.getEmailAddress1());
                userMergedContact.setPhoneNumber1(
                                contactInSystemViewer.getPhoneCheckbox().getValue() ? contactInSystem.getPhoneNumber1()
                                                : contactToBeImported.getPhoneNumber1());

        }

        private void handleMergeOptionChange(MergeOption option, CureDetails details) {
                contactToBeImportedViewer.showCheckboxes(false);
                switch (option) {
                        case KEEP_CONTACT_IN_SYSTEM:
                                userMergedContact = toContactDTO(details.getContactInSystem());
                                break;
                        case KEEP_CONTACT_TO_BE_IMPORTED:
                                userMergedContact = details.getContactToBeImported();
                                break;
                        case CUSTOM_MERGE:
                                contactToBeImportedViewer.showCheckboxes(true);
                                break;
                        default:
                                break;
                }

        }

        private ContactDTO toContactDTO(Contact contactInSystem) {
                ContactDTO contactDTO = new ContactDTO();
                contactDTO.setFirstName(contactInSystem.getFirstName());
                contactDTO.setLastName(contactInSystem.getLastName());
                contactDTO.setPhoneNumber1(phoneNumberToLong(contactInSystem.getPrimaryPhone()));
                contactDTO.setEmailAddress1(contactInSystem.getPrimaryEmailAddress());
                return contactDTO;
        }

        private Long phoneNumberToLong(String phoneNumber) {
                return Long.parseLong(phoneNumber.replace("-", ""));
        }

        private String longToPhoneNumberString(Long phoneNumber1) {
                if (phoneNumber1 == null) {
                        return "";
                }
                return String.format("(%s) %s-%s", phoneNumber1.toString().substring(0, 3),
                                phoneNumber1.toString().substring(3, 6), phoneNumber1.toString().substring(6));
        }

        @Override
        protected void onProceed(CureDetails details, Consumer<CureDetails> onApply) {
                CureOption selectedOption = CureOption.MERGE_CONTACTS;
                details.setSelectedCure(selectedOption);
                details.setUserMergedContact(userMergedContact);
                onApply.accept(details);
        }
}
