package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.interfaces;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

@Component
public interface IssueDialogStrategy {
    void showDialog(CureDetails details, Consumer<CureDetails> onApply);
}
