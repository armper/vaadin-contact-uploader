package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;

@CssImport("./styles/info-card.css")
public class ContactInfoLayout extends VerticalLayout {
    @FunctionalInterface
    public interface CheckboxChangeListener {
        void onCheckboxChange();
    }

    private CheckboxChangeListener checkboxChangeListener;

    private final Label nameLabel = new Label();
    private final Label warningLabel = new Label("Name will be overwritten in the system.");
    private final Checkbox nameCheckbox = new Checkbox();

    private List<EmailComponent> emailComponents = new ArrayList<>();
    private List<PhoneComponent> phoneComponents = new ArrayList<>();
    private List<AddressComponent> addressComponents = new ArrayList<>();

    private ContactDTO contactDTO;

    public ContactInfoLayout() {
        addClassName("info-card");
        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents() {

        warningLabel.addClassName(LumoUtility.TextColor.ERROR);

        nameCheckbox.setVisible(false);

        nameCheckbox.addValueChangeListener(listener -> warningLabel.setVisible(listener.getValue()));
    }

    private void layoutComponents() {
        warningLabel.setVisible(false);

        Avatar userAvatar = new Avatar();
        userAvatar.addClassName("user-avatar");

        HorizontalLayout header = new HorizontalLayout(nameCheckbox, userAvatar, nameLabel, warningLabel);
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.addClassName("contact-header");

        add(header);
    }

    public void setContact(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
        nameLabel.setText(contactDTO.getFirstName() + " " + contactDTO.getLastName());
        updateAvatar(contactDTO.getFirstName(), contactDTO.getLastName());

        removeAll();
        layoutComponents();

        add(new Hr());
        handleEmails(contactDTO);
        add(new Hr());
        handlePhones(contactDTO);
        add(new Hr());
        handleAddresses(contactDTO);
    }

    private void handlePhones(ContactDTO contactDTO) {
        addPhoneComponent(contactDTO.getPhoneType1(), contactDTO.getPhoneNumber1(), contactDTO.getPhoneExtension1(),
                contactDTO.getPhoneSms1());
        addPhoneComponent(contactDTO.getPhoneType2(), contactDTO.getPhoneNumber2(), contactDTO.getPhoneExtension2(),
                contactDTO.getPhoneSms2());
        addPhoneComponent(contactDTO.getPhoneType3(), contactDTO.getPhoneNumber3(), contactDTO.getPhoneExtension3(),
                contactDTO.getPhoneSms3());
    }

    private void addPhoneComponent(String phoneType, Long phoneNumber, String phoneExtension, Boolean phoneSms) {
        if (phoneNumber != null) {
            PhoneComponent phoneComp = new PhoneComponent();
            phoneComp.setPhone(phoneType, phoneNumber, phoneExtension, phoneSms);
            phoneComponents.add(phoneComp);
            add(phoneComp);
            phoneComp.getPhoneCheckbox().addValueChangeListener(e -> notifyCheckboxChange());
        }
    }

    private void handleAddresses(ContactDTO contactDTO) {
        addAddressComponent(contactDTO.getAddressType1(), contactDTO.getAddressFieldA1(),
                contactDTO.getAddressFieldB1(),
                contactDTO.getAddressCity1(), contactDTO.getAddressState1(), contactDTO.getAddressProvince1(),
                contactDTO.getAddressCountry1(), contactDTO.getAddressCounty1(), contactDTO.getAddressPostalCode1());

        addAddressComponent(contactDTO.getAddressType2(), contactDTO.getAddressFieldA2(),
                contactDTO.getAddressFieldB2(),
                contactDTO.getAddressCity2(), contactDTO.getAddressState2(), contactDTO.getAddressProvince2(),
                contactDTO.getAddressCountry2(), contactDTO.getAddressCounty2(), contactDTO.getAddressPostalCode2());

        addAddressComponent(contactDTO.getAddressType3(), contactDTO.getAddressFieldA3(),
                contactDTO.getAddressFieldB3(),
                contactDTO.getAddressCity3(), contactDTO.getAddressState3(), contactDTO.getAddressProvince3(),
                contactDTO.getAddressCountry3(), contactDTO.getAddressCounty3(), contactDTO.getAddressPostalCode3());

    }

    private void handleEmails(ContactDTO contactDTO) {
        addEmailComponent(contactDTO.getEmailType1(), contactDTO.getEmailAddress1());
        addEmailComponent(contactDTO.getEmailType2(), contactDTO.getEmailAddress2());
        addEmailComponent(contactDTO.getEmailType3(), contactDTO.getEmailAddress3());
    }

    private void addAddressComponent(String addressType, String fieldA, String fieldB, String city,
            String state, String province, String country, String county, String postalCode) {
        // Check if the primary field of the address (e.g., fieldA) is not empty
        if (fieldA != null && !fieldA.isEmpty()) {
            AddressComponent addressComp = new AddressComponent();
            addressComp.setAddress(addressType, fieldA, fieldB, city, state, province, country, county, postalCode);
            addressComponents.add(addressComp);
            add(addressComp);
            addressComp.getAddressCheckbox().addValueChangeListener(e -> notifyCheckboxChange());
        }
    }

    private void addEmailComponent(String emailType, String emailAddress) {
        if (emailAddress != null && !emailAddress.isEmpty()) {
            EmailComponent emailComponent = new EmailComponent();
            emailComponent.setEmail(emailAddress, emailType);
            emailComponents.add(emailComponent);
            add(emailComponent);
            emailComponent.getEmailCheckbox().addValueChangeListener(e -> notifyCheckboxChange());
        }
    }

    private void notifyCheckboxChange() {
        if (checkboxChangeListener != null) {
            checkboxChangeListener.onCheckboxChange();
        }
    }

    public void showCheckboxes(boolean show) {
        nameCheckbox.setVisible(show);
        emailComponents.forEach(comp -> comp.showCheckbox(show));
        phoneComponents.forEach(comp -> comp.showCheckbox(show));
        addressComponents.forEach(comp -> comp.showCheckbox(show));
    }

    public void setCheckboxChangeListener(CheckboxChangeListener listener) {
        this.checkboxChangeListener = listener;
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

    public ContactDTO getSelectedContactData() {
        ContactDTO selectedContact = new ContactDTO();
        if (nameCheckbox.getValue()) {
            selectedContact.setFirstName(contactDTO.getFirstName());
            selectedContact.setLastName(contactDTO.getLastName());
        }

        // Collect selected emails, phones, and addresses
        for (EmailComponent emailComp : emailComponents) {
            if (emailComp.getEmailCheckbox().getValue()) {
                selectedContact.setEmailType1(emailComp.getEmail());
                selectedContact.setEmailAddress1(emailComp.getEmail());
            }
        }
        for (PhoneComponent phoneComp : phoneComponents) {
            if (phoneComp.getPhoneCheckbox().getValue()) {

                selectedContact.setPhoneType1(phoneComp.getPhoneType());
                selectedContact.setPhoneNumber1(phoneNumberToLong(phoneComp.getPhone()));
                selectedContact.setPhoneExtension1(phoneComp.getExtensionLabel().getText());
            }
        }
        for (AddressComponent addressComp : addressComponents) {
            if (addressComp.getAddressCheckbox().getValue()) {
                selectedContact.setAddressType1(addressComp.getAddressTypeLabel().getText());
                selectedContact.setAddressFieldA1(addressComp.getAddressFieldALabel().getText());
                selectedContact.setAddressFieldB1(addressComp.getAddressFieldBLabel().getText());
                selectedContact.setAddressCity1(addressComp.getCityLabel().getText());
                selectedContact.setAddressState1(addressComp.getStateLabel().getText());
                selectedContact.setAddressProvince1(addressComp.getProvinceLabel().getText());
                selectedContact.setAddressCountry1(addressComp.getCountryLabel().getText());
                selectedContact.setAddressCounty1(addressComp.getCountyLabel().getText());
                selectedContact.setAddressPostalCode1(addressComp.getPostalCodeLabel().getText());
            }
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

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public Checkbox getNameCheckbox() {
        return nameCheckbox;
    }

    public CheckboxChangeListener getCheckboxChangeListener() {
        return checkboxChangeListener;
    }

    public List<EmailComponent> getEmailComponents() {
        return emailComponents;
    }

    public void setEmailComponents(List<EmailComponent> emailComponents) {
        this.emailComponents = emailComponents;
    }

    public List<PhoneComponent> getPhoneComponents() {
        return phoneComponents;
    }

    public void setPhoneComponents(List<PhoneComponent> phoneComponents) {
        this.phoneComponents = phoneComponents;
    }

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

}
