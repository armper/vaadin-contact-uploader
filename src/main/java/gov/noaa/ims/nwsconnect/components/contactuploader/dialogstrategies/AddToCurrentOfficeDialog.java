package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components.ContactInfoLayout;
import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces.BaseDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType.CureOption;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@UIScope
@Component
public class AddToCurrentOfficeDialog extends BaseDialog {
        RadioButtonGroup<String> options = new RadioButtonGroup<>();
        private String nonPrimaryContactString;
        private String importAsNewContactString;

        @Override
        protected void buildDialogLayout(Dialog dialog, CureDetails details, Consumer<CureDetails> onApply) {
                // Create instances of the ContactInfoLayout for displaying contact details
                ContactInfoLayout contactInSystemViewer = new ContactInfoLayout();
                ContactInfoLayout contactToBeImportedViewer = new ContactInfoLayout();

                // Set the contact details to the viewer
                contactInSystemViewer.setContact(details.getContactInSystem());

                contactToBeImportedViewer.setContact(details.getContactToBeImported());

                options.setThemeName("vertical");
                nonPrimaryContactString = "Add as non-primary contact to current office "
                                + details.getContactInSystem().getOffice()
                                + " (Other information will not be imported)";
                importAsNewContactString = "Import as a new contact into "
                                + details.getContactToBeImported().getOffice();
                options.setItems(nonPrimaryContactString, importAsNewContactString);
                options.setLabel("Select an option:");

                // Add the ContactInfoLayout instances and other components to the dialog
                Paragraph warningHeader = new Paragraph("The contact is already in the system in office "
                                + details.getContactInSystem().getOffice());
                dialog.add(new VerticalLayout(
                                warningHeader,
                                new Label("Contact To Be Imported:"),
                                contactToBeImportedViewer,
                                new Label("Contact In the System:"),
                                contactInSystemViewer,
                                options));
        }

        @Override
        protected void onProceed(CureDetails details, Consumer<CureDetails> onApply) {
                String selectedOption = options.getValue(); // 'options' should be a class member to be accessible here
                if (nonPrimaryContactString.equals(selectedOption)) {
                        details.setSelectedCure(CureOption.ADD_AS_NON_PRIMARY_CONTACT);
                } else if (importAsNewContactString.equals(selectedOption)) {
                        details.setSelectedCure(CureOption.IMPORT_AS_NEW_CONTACT);
                }
                onApply.accept(details);
        }
}
