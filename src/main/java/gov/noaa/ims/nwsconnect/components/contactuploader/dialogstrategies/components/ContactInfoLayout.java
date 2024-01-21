package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;

@CssImport("./styles/info-card.css")
public class ContactInfoLayout extends VerticalLayout {
    @FunctionalInterface
    public interface CheckboxChangeListener {
        void onCheckboxChange();
    }

    private CheckboxChangeListener checkboxChangeListener;

    private final Label nameLabel = new Label();
    private final Label emailLabel = new Label();
    private final Label phoneLabel = new Label();
    private final Label officeLabel = new Label();

    private final Checkbox nameCheckbox = new Checkbox();
    private final Checkbox emailCheckbox = new Checkbox();
    private final Checkbox phoneCheckbox = new Checkbox();

    private ContactDTO contactDTO;

    public ContactInfoLayout() {
        addClassName("info-card");
        initializeComponents();
        layoutComponents();

        attachValueChangeListeners();
    }

    private void attachValueChangeListeners() {
        nameCheckbox.addValueChangeListener(e -> notifyCheckboxChange());
        emailCheckbox.addValueChangeListener(e -> notifyCheckboxChange());
        phoneCheckbox.addValueChangeListener(e -> notifyCheckboxChange());

    }

    private void notifyCheckboxChange() {
        if (checkboxChangeListener != null) {
            checkboxChangeListener.onCheckboxChange();
        }
    }

    private void initializeComponents() {

        nameCheckbox.setVisible(false);
        emailCheckbox.setVisible(false);
        phoneCheckbox.setVisible(false);
        nameLabel.addClassName("contact-name");
    }

    private void layoutComponents() {
        Avatar userAvatar = new Avatar();
        userAvatar.addClassName("user-avatar");

        nameLabel.addClassName("contact-name");
        nameCheckbox.setVisible(false);

        HorizontalLayout header = new HorizontalLayout(userAvatar, nameLabel, nameCheckbox);
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.addClassName("contact-header");

        HorizontalLayout emailLayout = createFieldLayout(emailCheckbox, VaadinIcon.ENVELOPE, emailLabel);
        HorizontalLayout phoneLayout = createFieldLayout(phoneCheckbox, VaadinIcon.PHONE, phoneLabel);
        HorizontalLayout officeLayout = createFieldLayout(null, VaadinIcon.OFFICE, officeLabel);

        add(header, officeLayout, phoneLayout, emailLayout);
    }

    private HorizontalLayout createFieldLayout(Checkbox checkbox, VaadinIcon icon, Label label) {
        Icon vaadinIcon = icon != null ? new Icon(icon) : null;
        if (vaadinIcon != null) {
            label.addClassName("contact-" + label.getElement().getTag());
        }
        HorizontalLayout layout = new HorizontalLayout();
        if (vaadinIcon != null) {
            layout.add(vaadinIcon);
        }
        layout.add(label);

        if (checkbox != null) {
            checkbox.setVisible(false); // Initialize the checkbox to be hidden
            layout.add(checkbox);
        }

        layout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        return layout;
    }

    public void setContact(String firstName, String lastName, String emailAddress, String phoneNumber, String office) {
        nameLabel.setText(firstName + " " + lastName);
        emailLabel.setText(emailAddress);
        phoneLabel.setText(phoneNumber != null ? phoneNumber : "");
        officeLabel.setText(office);
        storeContactDetails(firstName, lastName, emailAddress, phoneNumber);
        updateAvatar(firstName, lastName);
    }

    private void storeContactDetails(String firstName, String lastName, String emailAddress, String phoneNumber) {
        contactDTO = new ContactDTO();
        contactDTO.setFirstName(firstName);
        contactDTO.setLastName(lastName);
        contactDTO.setEmailAddress1(emailAddress);
        try {
            contactDTO.setPhoneNumber1(phoneNumberToLong(phoneNumber));
        } catch (NumberFormatException e) {
            // Handle invalid phone number format
        }
    }

    private void updateAvatar(String firstName, String lastName) {
        String initials = (!firstName.isEmpty() ? firstName.substring(0, 1) : "")
                + (!lastName.isEmpty() ? lastName.substring(0, 1) : "");
        Avatar userAvatar = new Avatar(initials);
        userAvatar.addClassName("user-avatar");

        HorizontalLayout header = (HorizontalLayout) getComponentAt(0);
        header.remove(header.getComponentAt(0));
        header.addComponentAtIndex(0, userAvatar);
    }

    public void showCheckboxes(boolean show) {
        nameCheckbox.setVisible(show);
        emailCheckbox.setVisible(show);
        phoneCheckbox.setVisible(show);
    }

    public ContactDTO getSelectedContactData() {
        ContactDTO selectedContact = new ContactDTO();
        if (nameCheckbox.getValue()) {
            selectedContact.setFirstName(contactDTO.getFirstName());
            selectedContact.setLastName(contactDTO.getLastName());
        }
        if (emailCheckbox.getValue()) {
            selectedContact.setEmailAddress1(contactDTO.getEmailAddress1());
        }
        if (phoneCheckbox.getValue()) {
            selectedContact.setPhoneNumber1(contactDTO.getPhoneNumber1());
        }
        return selectedContact;
    }

    private Long phoneNumberToLong(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty() ? Long.parseLong(phoneNumber.replaceAll("[^\\d]", ""))
                : null;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getEmailLabel() {
        return emailLabel;
    }

    public Label getPhoneLabel() {
        return phoneLabel;
    }

    public Label getOfficeLabel() {
        return officeLabel;
    }

    public Checkbox getNameCheckbox() {
        return nameCheckbox;
    }

    public Checkbox getEmailCheckbox() {
        return emailCheckbox;
    }

    public Checkbox getPhoneCheckbox() {
        return phoneCheckbox;
    }

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public void setCheckboxChangeListener(CheckboxChangeListener listener) {
        this.checkboxChangeListener = listener;
    }

}
