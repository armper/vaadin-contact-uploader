package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PhoneComponent extends HorizontalLayout {
    VerticalLayout phoneDetailsLayout = new VerticalLayout();

    private Label phoneTypeLabel = new Label();
    private Label phoneLabel = new Label();
    private Label extensionLabel = new Label();
    private Label canRecieveSmsCheckbox = new Label();
    private Checkbox phoneCheckbox = new Checkbox();

    public PhoneComponent() {

        phoneDetailsLayout.setPadding(false);
        phoneDetailsLayout.setSpacing(false);

        // Add components to the layout
        add(phoneCheckbox);
        phoneDetailsLayout.add(new HorizontalLayout(phoneLabel, extensionLabel, canRecieveSmsCheckbox));

        add(phoneDetailsLayout);

        phoneCheckbox.setVisible(false);

        add(phoneTypeLabel);

        setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        setWidthFull();
    }

    public void setPhone(String phoneType, Long phoneNumber, String phoneExtension, Boolean canRecieveSms) {
        if (phoneType != null) {
            this.phoneTypeLabel.setText(phoneType);
        } else {
            this.phoneTypeLabel.setText("");
        }
        this.phoneLabel.setText(longToPhoneString(phoneNumber));
        if (phoneExtension != null) {
            this.extensionLabel.setText("ext. " + phoneExtension);
        } else {
            this.extensionLabel.setText("");
        }

        if (canRecieveSms != null) {
            if (canRecieveSms) {
                this.canRecieveSmsCheckbox.setText("Can receive SMS");
            } else {
                this.canRecieveSmsCheckbox.setText("Cannot receive SMS");
            }
        } else {
            this.canRecieveSmsCheckbox.setText("");
        }

    }

    private String longToPhoneString(Long phoneNumber) {
        // format the phone number
        String phone = phoneNumber.toString();
        if (phone.length() == 10) {
            phone = "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
        } else if (phone.length() == 7) {
            phone = phone.substring(0, 3) + "-" + phone.substring(3);
        }
        return phone;
    }

    public Checkbox getPhoneCheckbox() {
        return phoneCheckbox;
    }

    public void showCheckbox(boolean show) {
        phoneCheckbox.setVisible(show);
    }

    public String getPhone() {
        return phoneLabel.getText();
    }

    public String getPhoneType() {
        return phoneTypeLabel.getText();
    }

    public Label getPhoneTypeLabel() {
        return phoneTypeLabel;
    }

    public void setPhoneTypeLabel(Label phoneTypeLabel) {
        this.phoneTypeLabel = phoneTypeLabel;
    }

    public Label getPhoneLabel() {
        return phoneLabel;
    }

    public void setPhoneLabel(Label phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    public Label getExtensionLabel() {
        return extensionLabel;
    }

    public void setExtensionLabel(Label extensionLabel) {
        this.extensionLabel = extensionLabel;
    }

    public void setPhoneCheckbox(Checkbox phoneCheckbox) {
        this.phoneCheckbox = phoneCheckbox;
    }

}
