package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies.components;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AddressComponent extends HorizontalLayout {
    private VerticalLayout addressDetailsLayout = new VerticalLayout();

    private Label addressTypeLabel = new Label();
    private Label addressFieldALabel = new Label();
    private Label addressFieldBLabel = new Label();
    private Label cityLabel = new Label();
    private Label stateLabel = new Label();
    private Label provinceLabel = new Label();
    private Label countryLabel = new Label();
    private Label countyLabel = new Label();
    private Label postalCodeLabel = new Label();

    private Checkbox addressCheckbox = new Checkbox();

    public AddressComponent() {

        addressCheckbox.setVisible(false);
        add(addressCheckbox);

        addressDetailsLayout.setPadding(false);
        addressDetailsLayout.setSpacing(false);

        add(addressTypeLabel);

        // Add labels to the addressDetailsLayout
        HorizontalLayout addressLayout = new HorizontalLayout(addressFieldALabel, addressFieldBLabel);
        addressLayout.setPadding(false);
        
        HorizontalLayout cityStateZipLayout = new HorizontalLayout(cityLabel, stateLabel, provinceLabel, countyLabel,
                postalCodeLabel);
        cityStateZipLayout.setPadding(false);

        addressDetailsLayout.add(addressLayout,
                cityStateZipLayout, countryLabel);

        // Add addressDetailsLayout to the main layout
        add(addressDetailsLayout);
    }

    public void setAddress(String addressType, String addressFieldA, String addressFieldB, String city,
            String state, String province, String country, String county, String postalCode) {
        addressTypeLabel.setText(addressType);
        addressFieldALabel.setText(addressFieldA);
        addressFieldBLabel.setText(addressFieldB);
        cityLabel.setText(city);
        stateLabel.setText(state);
        provinceLabel.setText(province);
        countryLabel.setText(country);
        countyLabel.setText(county);
        postalCodeLabel.setText(postalCode);
    }

    public Label getAddressTypeLabel() {
        return addressTypeLabel;
    }

    public void setAddressTypeLabel(Label addressTypeLabel) {
        this.addressTypeLabel = addressTypeLabel;
    }

    public Label getAddressFieldALabel() {
        return addressFieldALabel;
    }

    public void setAddressFieldALabel(Label addressFieldALabel) {
        this.addressFieldALabel = addressFieldALabel;
    }

    public Label getAddressFieldBLabel() {
        return addressFieldBLabel;
    }

    public void setAddressFieldBLabel(Label addressFieldBLabel) {
        this.addressFieldBLabel = addressFieldBLabel;
    }

    public Label getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(Label cityLabel) {
        this.cityLabel = cityLabel;
    }

    public Label getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(Label stateLabel) {
        this.stateLabel = stateLabel;
    }

    public Label getProvinceLabel() {
        return provinceLabel;
    }

    public void setProvinceLabel(Label provinceLabel) {
        this.provinceLabel = provinceLabel;
    }

    public Label getCountryLabel() {
        return countryLabel;
    }

    public void setCountryLabel(Label countryLabel) {
        this.countryLabel = countryLabel;
    }

    public Label getCountyLabel() {
        return countyLabel;
    }

    public void setCountyLabel(Label countyLabel) {
        this.countyLabel = countyLabel;
    }

    public Label getPostalCodeLabel() {
        return postalCodeLabel;
    }

    public void setPostalCodeLabel(Label postalCodeLabel) {
        this.postalCodeLabel = postalCodeLabel;
    }

    public Checkbox getAddressCheckbox() {
        return addressCheckbox;
    }

    public void setAddressCheckbox(Checkbox addressCheckbox) {
        this.addressCheckbox = addressCheckbox;
    }

    public void showCheckbox(boolean show) {
        addressCheckbox.setVisible(show);
    }

}
