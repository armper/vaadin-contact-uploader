package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.spring.annotation.UIScope;

import gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces.BaseDialog;
import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType.CureOption;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@UIScope
@Component
public class NoaaLinkDialog extends BaseDialog {

    @Override
    protected void buildDialogLayout(Dialog dialog, CureDetails details, Consumer<CureDetails> onApply) {
        String emailAddress = details.getContactToBeImported().getEmailAddress1();

        dialog.add(new Paragraph("Proceed to send an invitation link to: " + emailAddress + "."));
        dialog.add(new Paragraph(
                "The system will automatically send an email to the user. If the user is not registered, they will be prompted to complete the registration process. If they are already registered, no further action will be taken."));

        details.setSelectedCure(CureOption.SEND_INVITE_LINK_FOR_NOAA);
    }

    @Override
    protected void onProceed(CureDetails details, Consumer<CureDetails> onApply) {
        onApply.accept(details);
    }

}
