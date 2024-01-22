package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class EmailComponent extends HorizontalLayout {
    VerticalLayout emailDetailsLayout = new VerticalLayout();

    private Label emailLabel = new Label("");
    private Label emailType = new Label("");
    private Checkbox emailCheckbox = new Checkbox();

    public EmailComponent() {
        emailDetailsLayout.setPadding(false);
        emailDetailsLayout.setSpacing(false);

  
        // Add components to the layout
        add(emailCheckbox);
        emailDetailsLayout.add(emailLabel);
        add(emailDetailsLayout);

        emailCheckbox.setVisible(false);

        add(emailType);

        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        setWidthFull(); 

    }

    public void setEmail(String email, String emailType) {
        this.emailLabel.setText(email);
        this.emailType.setText(emailType);
    }

    public Checkbox getEmailCheckbox() {
        return emailCheckbox;
    }

    public void showCheckbox(boolean show) {
        emailCheckbox.setVisible(show);
    }

    public String getEmail() {
        return emailLabel.getText();
    }

}
