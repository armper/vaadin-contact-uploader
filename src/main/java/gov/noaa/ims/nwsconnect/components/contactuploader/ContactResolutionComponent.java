package gov.noaa.ims.nwsconnect.components.contactuploader;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ContactResolutionComponent extends VerticalLayout {
    private final Button resolveButton;
    private final Paragraph resolvedLabel;

    public ContactResolutionComponent() {

        resolveButton = new Button("Select Resolution");
        resolvedLabel = new Paragraph("Resolved");
        resolvedLabel.getStyle().set("color", "var(--lumo-success-text-color)");
        resolvedLabel.setVisible(false); // Initially hidden

        add(resolveButton, resolvedLabel);
    }

    public void markAsResolved() {
        resolveButton.setEnabled(false);
        resolvedLabel.setVisible(true);
    }

    public Button getResolveButton() {
        return resolveButton;
    }

}
