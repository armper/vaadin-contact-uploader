package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

import java.util.function.Consumer;

public abstract class BaseDialog implements IssueDialogStrategy {

    protected abstract void buildDialogLayout(Dialog dialog, CureDetails details, Consumer<CureDetails> onApply);

    @Override
    public void showDialog(CureDetails details, Consumer<CureDetails> onApply) {
        Dialog dialog = new Dialog();
        buildDialogLayout(dialog, details, onApply);

        Button proceedButton = new Button("Proceed", event -> {
            onProceed(details, onApply);
            dialog.close();
        });
        proceedButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancelButton = new Button("Cancel", event -> dialog.close());

        dialog.add(new VerticalLayout(proceedButton, cancelButton));
        dialog.setCloseOnOutsideClick(false);
        dialog.open();
    }

    protected abstract void onProceed(CureDetails details, Consumer<CureDetails> onApply);
}
