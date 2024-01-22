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
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@UIScope
@Component
public class MergeContactsDialog extends BaseDialog {

        private ContactDTO userMergedContact;

        private ContactInfoLayout contactInSystemViewer;

        private ContactInfoLayout contactToBeImportedViewer;

        @Override
        protected void buildDialogLayout(Dialog dialog, CureDetails details, Consumer<CureDetails> onApply) {
                contactInSystemViewer = new ContactInfoLayout();
                contactToBeImportedViewer = new ContactInfoLayout();

                contactInSystemViewer.setContact(details.getContactInSystem());
                contactToBeImportedViewer.setContact(details.getContactToBeImported());
                contactToBeImportedViewer.showCheckboxes(true);

                contactInSystemViewer.setCheckboxChangeListener(this::updateMergedContact);
                contactToBeImportedViewer.setCheckboxChangeListener(this::updateMergedContact);

                dialog.add(new VerticalLayout(
                                contactToBeImportedViewer,
                                contactInSystemViewer));

                H3 warningHeader = new H3(
                                "Merge the contacts for the following contact in the "
                                                + details.getContactInSystem().getOffice()
                                                + " office.");
                dialog.add(new VerticalLayout(
                                warningHeader,
                                new Paragraph("Select the fields from the imported contact to add in the existing contact."),
                                new H4("Contact To Be Imported:"),
                                contactToBeImportedViewer,
                                new H4("Contact In the System:"),
                                contactInSystemViewer));
        }

        private void updateMergedContact() {
                // Implement logic to update userMergedContact based on checkbox states
                ContactDTO contactInSystem = contactInSystemViewer.getSelectedContactData();
                ContactDTO contactToBeImported = contactToBeImportedViewer.getSelectedContactData();

                userMergedContact = new ContactDTO();
                userMergedContact.setFirstName(
                                contactInSystemViewer.getNameCheckbox().getValue() ? contactInSystem.getFirstName()
                                                : contactToBeImported.getFirstName());
                userMergedContact.setLastName(
                                contactInSystemViewer.getNameCheckbox().getValue() ? contactInSystem.getLastName()
                                                : contactToBeImported.getLastName());
                /*
                 * userMergedContact.setEmailAddress1(
                 * contactInSystemViewer.getEmailCheckbox().getValue() ?
                 * contactInSystem.getEmailAddress1()
                 * : contactToBeImported.getEmailAddress1());
                 * userMergedContact.setPhoneNumber1(
                 * contactInSystemViewer.getPhoneCheckbox().getValue() ?
                 * contactInSystem.getPhoneNumber1()
                 * : contactToBeImported.getPhoneNumber1());
                 */

        }

        @Override
        protected void onProceed(CureDetails details, Consumer<CureDetails> onApply) {
                CureOption selectedOption = CureOption.MERGE_CONTACTS;
                details.setSelectedCure(selectedOption);
                details.setUserMergedContact(userMergedContact);
                onApply.accept(details);
        }
}
