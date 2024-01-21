package gov.noaa.ims.nwsconnect.components.contactuploader;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.progressbar.ProgressBar;

public class ProcessingIndicatorComponent extends Div {
    private ProgressBar progressBar;

    public ProcessingIndicatorComponent() {
        progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);
        this.add(progressBar);
        this.setVisible(false);
    }

    public void startProcessing() {
        this.setVisible(true);
    }

    public void stopProcessing() {
        this.setVisible(false);
    }
}
