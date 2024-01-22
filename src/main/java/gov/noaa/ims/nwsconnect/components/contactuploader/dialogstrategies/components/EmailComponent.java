package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class EmailComponent extends HorizontalLayout {

    private Label emailLabel = new Label("");
    private Label emailType = new Label("");
    private Checkbox emailCheckbox = new Checkbox();

    public EmailComponent() {
        // Initialize layout and components
        setDefaultVerticalComponentAlignment(Alignment.CENTER);

        // Add components to the layout
        add(emailCheckbox);
        add(emailLabel, emailType);

        emailCheckbox.setVisible(false);

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
