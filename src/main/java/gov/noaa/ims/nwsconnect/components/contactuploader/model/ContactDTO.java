package gov.noaa.ims.nwsconnect.components.contactuploader.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ContactDTO {

    @JsonProperty("contactBaseType")
    private String contactBaseType;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("contactType")
    private String contactType;
    @JsonProperty("organizationName")
    private String organizationName;
    @JsonProperty("idssSector")
    private String idssSector;
    @JsonProperty("website")
    private String website;
    @JsonProperty("facebookId")
    private String facebookId;
    @JsonProperty("twitterId")
    private String twitterId;
    @JsonProperty("extraFieldPlaceholder")
    private String extraFieldPlaceholder;
    @JsonProperty("emailType1")
    private String emailType1;
    @JsonProperty("emailAddress1")
    private String emailAddress1;
    @JsonProperty("emailType2")
    private String emailType2;
    @JsonProperty("emailAddress2")
    private String emailAddress2;
    @JsonProperty("emailType3")
    private String emailType3;
    @JsonProperty("emailAddress3")
    private String emailAddress3;
    @JsonProperty("phoneType1")
    private String phoneType1;
    @JsonProperty("phoneNumber1")
    private Long phoneNumber1;
    @JsonProperty("phoneExtension1")
    private String phoneExtension1;
    @JsonProperty("phoneSms1")
    private Boolean phoneSms1;
    @JsonProperty("phoneType2")
    private String phoneType2;
    @JsonProperty("phoneNumber2")
    private Long phoneNumber2;
    @JsonProperty("phoneExtension2")
    private String phoneExtension2;
    @JsonProperty("phoneSms2")
    private Boolean phoneSms2;
    @JsonProperty("phoneType3")
    private String phoneType3;
    @JsonProperty("phoneNumber3")
    private Long phoneNumber3;
    @JsonProperty("phoneExtension3")
    private String phoneExtension3;
    @JsonProperty("phoneSms3")
    private Boolean phoneSms3;
    @JsonProperty("phoneType4")
    private String phoneType4;
    @JsonProperty("phoneNumber4")
    private String phoneNumber4;
    @JsonProperty("phoneExtension4")
    private String phoneExtension4;
    @JsonProperty("phoneSms4")
    private Boolean phoneSms4;
    @JsonProperty("addressType1")
    private String addressType1;
    @JsonProperty("addressFieldA1")
    private String addressFieldA1;
    @JsonProperty("addressFieldB1")
    private String addressFieldB1;
    @JsonProperty("addressCity1")
    private String addressCity1;
    @JsonProperty("addressState1")
    private String addressState1;
    @JsonProperty("addressProvince1")
    private String addressProvince1;
    @JsonProperty("addressCountry1")
    private String addressCountry1;
    @JsonProperty("addressCounty1")
    private String addressCounty1;
    @JsonProperty("addressPostalCode1")
    private String addressPostalCode1;
    @JsonProperty("addressType2")
    private String addressType2;
    @JsonProperty("addressFieldA2")
    private String addressFieldA2;
    @JsonProperty("addressFieldB2")
    private String addressFieldB2;
    @JsonProperty("addressCity2")
    private String addressCity2;
    @JsonProperty("addressState2")
    private String addressState2;
    @JsonProperty("addressProvince2")
    private String addressProvince2;
    @JsonProperty("addressCountry2")
    private String addressCountry2;
    @JsonProperty("addressCounty2")
    private String addressCounty2;
    @JsonProperty("addressPostalCode2")
    private String addressPostalCode2;
    @JsonProperty("addressType3")
    private String addressType3;
    @JsonProperty("addressFieldA3")
    private String addressFieldA3;
    @JsonProperty("addressFieldB3")
    private String addressFieldB3;
    @JsonProperty("addressCity3")
    private String addressCity3;
    @JsonProperty("addressState3")
    private String addressState3;
    @JsonProperty("addressProvince3")
    private String addressProvince3;
    @JsonProperty("addressCountry3")
    private String addressCountry3;
    @JsonProperty("addressCounty3")
    private String addressCounty3;
    @JsonProperty("addressPostalCode3")
    private String addressPostalCode3;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("spotter")
    private Boolean spotter;
    @JsonProperty("spotterId")
    private String spotterId;
    @JsonProperty("spotterTrainingDate")
    private String spotterTrainingDate;
    @JsonProperty("anemometer")
    private Boolean anemometer;
    @JsonProperty("barometer")
    private Boolean barometer;
    @JsonProperty("rainGauge")
    private Boolean rainGauge;
    @JsonProperty("riverGauge")
    private Boolean riverGauge;
    @JsonProperty("river")
    private String river;
    @JsonProperty("hasSnow")
    private Boolean hasSnow;
    @JsonProperty("thermometer")
    private Boolean thermometer;
    @JsonProperty("weatherStation")
    private Boolean weatherStation;
    @JsonProperty("cocorahs")
    private Boolean cocorahs;
    @JsonProperty("cocorahsId")
    private String cocorahsId;
    @JsonProperty("coop")
    private Boolean coop;
    @JsonProperty("coopId")
    private String coopId;
    @JsonProperty("ham")
    private Boolean ham;
    @JsonProperty("hamCall")
    private String hamCall;

    private String office;

    public String getContactBaseType() {
        return contactBaseType;
    }

    public void setContactBaseType(String contactBaseType) {
        this.contactBaseType = contactBaseType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getIdssSector() {
        return idssSector;
    }

    public void setIdssSector(String idssSector) {
        this.idssSector = idssSector;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getExtraFieldPlaceholder() {
        return extraFieldPlaceholder;
    }

    public void setExtraFieldPlaceholder(String extraFieldPlaceholder) {
        this.extraFieldPlaceholder = extraFieldPlaceholder;
    }

    public String getEmailType1() {
        return emailType1;
    }

    public void setEmailType1(String emailType1) {
        this.emailType1 = emailType1;
    }

    public String getEmailAddress1() {
        return emailAddress1;
    }

    public void setEmailAddress1(String emailAddress1) {
        this.emailAddress1 = emailAddress1;
    }

    public String getEmailType2() {
        return emailType2;
    }

    public void setEmailType2(String emailType2) {
        this.emailType2 = emailType2;
    }

    public String getEmailAddress2() {
        return emailAddress2;
    }

    public void setEmailAddress2(String emailAddress2) {
        this.emailAddress2 = emailAddress2;
    }

    public String getEmailType3() {
        return emailType3;
    }

    public void setEmailType3(String emailType3) {
        this.emailType3 = emailType3;
    }

    public String getEmailAddress3() {
        return emailAddress3;
    }

    public void setEmailAddress3(String emailAddress3) {
        this.emailAddress3 = emailAddress3;
    }

    public String getPhoneType1() {
        return phoneType1;
    }

    public void setPhoneType1(String phoneType1) {
        this.phoneType1 = phoneType1;
    }

    public Long getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(Long phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneExtension1() {
        return phoneExtension1;
    }

    public void setPhoneExtension1(String phoneExtension1) {
        this.phoneExtension1 = phoneExtension1;
    }

    public Boolean getPhoneSms1() {
        return phoneSms1;
    }

    public void setPhoneSms1(Boolean phoneSms1) {
        this.phoneSms1 = phoneSms1;
    }

    public String getPhoneType2() {
        return phoneType2;
    }

    public void setPhoneType2(String phoneType2) {
        this.phoneType2 = phoneType2;
    }

    public Long getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Long phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getPhoneExtension2() {
        return phoneExtension2;
    }

    public void setPhoneExtension2(String phoneExtension2) {
        this.phoneExtension2 = phoneExtension2;
    }

    public Boolean getPhoneSms2() {
        return phoneSms2;
    }

    public void setPhoneSms2(Boolean phoneSms2) {
        this.phoneSms2 = phoneSms2;
    }

    public String getPhoneType3() {
        return phoneType3;
    }

    public void setPhoneType3(String phoneType3) {
        this.phoneType3 = phoneType3;
    }

    public Long getPhoneNumber3() {
        return phoneNumber3;
    }

    public void setPhoneNumber3(Long phoneNumber3) {
        this.phoneNumber3 = phoneNumber3;
    }

    public String getPhoneExtension3() {
        return phoneExtension3;
    }

    public void setPhoneExtension3(String phoneExtension3) {
        this.phoneExtension3 = phoneExtension3;
    }

    public Boolean getPhoneSms3() {
        return phoneSms3;
    }

    public void setPhoneSms3(Boolean phoneSms3) {
        this.phoneSms3 = phoneSms3;
    }

    public String getPhoneType4() {
        return phoneType4;
    }

    public void setPhoneType4(String phoneType4) {
        this.phoneType4 = phoneType4;
    }

    public String getPhoneNumber4() {
        return phoneNumber4;
    }

    public void setPhoneNumber4(String phoneNumber4) {
        this.phoneNumber4 = phoneNumber4;
    }

    public String getPhoneExtension4() {
        return phoneExtension4;
    }

    public void setPhoneExtension4(String phoneExtension4) {
        this.phoneExtension4 = phoneExtension4;
    }

    public Boolean getPhoneSms4() {
        return phoneSms4;
    }

    public void setPhoneSms4(Boolean phoneSms4) {
        this.phoneSms4 = phoneSms4;
    }

    public String getAddressType1() {
        return addressType1;
    }

    public void setAddressType1(String addressType1) {
        this.addressType1 = addressType1;
    }

    public String getAddressFieldA1() {
        return addressFieldA1;
    }

    public void setAddressFieldA1(String addressFieldA1) {
        this.addressFieldA1 = addressFieldA1;
    }

    public String getAddressFieldB1() {
        return addressFieldB1;
    }

    public void setAddressFieldB1(String addressFieldB1) {
        this.addressFieldB1 = addressFieldB1;
    }

    public String getAddressCity1() {
        return addressCity1;
    }

    public void setAddressCity1(String addressCity1) {
        this.addressCity1 = addressCity1;
    }

    public String getAddressState1() {
        return addressState1;
    }

    public void setAddressState1(String addressState1) {
        this.addressState1 = addressState1;
    }

    public String getAddressProvince1() {
        return addressProvince1;
    }

    public void setAddressProvince1(String addressProvince1) {
        this.addressProvince1 = addressProvince1;
    }

    public String getAddressCountry1() {
        return addressCountry1;
    }

    public void setAddressCountry1(String addressCountry1) {
        this.addressCountry1 = addressCountry1;
    }

    public String getAddressCounty1() {
        return addressCounty1;
    }

    public void setAddressCounty1(String addressCounty1) {
        this.addressCounty1 = addressCounty1;
    }

    public String getAddressPostalCode1() {
        return addressPostalCode1;
    }

    public void setAddressPostalCode1(String addressPostalCode1) {
        this.addressPostalCode1 = addressPostalCode1;
    }

    public String getAddressType2() {
        return addressType2;
    }

    public void setAddressType2(String addressType2) {
        this.addressType2 = addressType2;
    }

    public String getAddressFieldA2() {
        return addressFieldA2;
    }

    public void setAddressFieldA2(String addressFieldA2) {
        this.addressFieldA2 = addressFieldA2;
    }

    public String getAddressFieldB2() {
        return addressFieldB2;
    }

    public void setAddressFieldB2(String addressFieldB2) {
        this.addressFieldB2 = addressFieldB2;
    }

    public String getAddressCity2() {
        return addressCity2;
    }

    public void setAddressCity2(String addressCity2) {
        this.addressCity2 = addressCity2;
    }

    public String getAddressState2() {
        return addressState2;
    }

    public void setAddressState2(String addressState2) {
        this.addressState2 = addressState2;
    }

    public String getAddressProvince2() {
        return addressProvince2;
    }

    public void setAddressProvince2(String addressProvince2) {
        this.addressProvince2 = addressProvince2;
    }

    public String getAddressCountry2() {
        return addressCountry2;
    }

    public void setAddressCountry2(String addressCountry2) {
        this.addressCountry2 = addressCountry2;
    }

    public String getAddressCounty2() {
        return addressCounty2;
    }

    public void setAddressCounty2(String addressCounty2) {
        this.addressCounty2 = addressCounty2;
    }

    public String getAddressPostalCode2() {
        return addressPostalCode2;
    }

    public void setAddressPostalCode2(String addressPostalCode2) {
        this.addressPostalCode2 = addressPostalCode2;
    }

    public String getAddressType3() {
        return addressType3;
    }

    public void setAddressType3(String addressType3) {
        this.addressType3 = addressType3;
    }

    public String getAddressFieldA3() {
        return addressFieldA3;
    }

    public void setAddressFieldA3(String addressFieldA3) {
        this.addressFieldA3 = addressFieldA3;
    }

    public String getAddressFieldB3() {
        return addressFieldB3;
    }

    public void setAddressFieldB3(String addressFieldB3) {
        this.addressFieldB3 = addressFieldB3;
    }

    public String getAddressCity3() {
        return addressCity3;
    }

    public void setAddressCity3(String addressCity3) {
        this.addressCity3 = addressCity3;
    }

    public String getAddressState3() {
        return addressState3;
    }

    public void setAddressState3(String addressState3) {
        this.addressState3 = addressState3;
    }

    public String getAddressProvince3() {
        return addressProvince3;
    }

    public void setAddressProvince3(String addressProvince3) {
        this.addressProvince3 = addressProvince3;
    }

    public String getAddressCountry3() {
        return addressCountry3;
    }

    public void setAddressCountry3(String addressCountry3) {
        this.addressCountry3 = addressCountry3;
    }

    public String getAddressCounty3() {
        return addressCounty3;
    }

    public void setAddressCounty3(String addressCounty3) {
        this.addressCounty3 = addressCounty3;
    }

    public String getAddressPostalCode3() {
        return addressPostalCode3;
    }

    public void setAddressPostalCode3(String addressPostalCode3) {
        this.addressPostalCode3 = addressPostalCode3;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getSpotter() {
        return spotter;
    }

    public void setSpotter(Boolean spotter) {
        this.spotter = spotter;
    }

    public String getSpotterId() {
        return spotterId;
    }

    public void setSpotterId(String spotterId) {
        this.spotterId = spotterId;
    }

    public String getSpotterTrainingDate() {
        return spotterTrainingDate;
    }

    public void setSpotterTrainingDate(String spotterTrainingDate) {
        this.spotterTrainingDate = spotterTrainingDate;
    }

    public Boolean getAnemometer() {
        return anemometer;
    }

    public void setAnemometer(Boolean anemometer) {
        this.anemometer = anemometer;
    }

    public Boolean getBarometer() {
        return barometer;
    }

    public void setBarometer(Boolean barometer) {
        this.barometer = barometer;
    }

    public Boolean getRainGauge() {
        return rainGauge;
    }

    public void setRainGauge(Boolean rainGauge) {
        this.rainGauge = rainGauge;
    }

    public Boolean getRiverGauge() {
        return riverGauge;
    }

    public void setRiverGauge(Boolean riverGauge) {
        this.riverGauge = riverGauge;
    }

    public String getRiver() {
        return river;
    }

    public void setRiver(String river) {
        this.river = river;
    }

    public Boolean getHasSnow() {
        return hasSnow;
    }

    public void setHasSnow(Boolean hasSnow) {
        this.hasSnow = hasSnow;
    }

    public Boolean getThermometer() {
        return thermometer;
    }

    public void setThermometer(Boolean thermometer) {
        this.thermometer = thermometer;
    }

    public Boolean getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(Boolean weatherStation) {
        this.weatherStation = weatherStation;
    }

    public Boolean getCocorahs() {
        return cocorahs;
    }

    public void setCocorahs(Boolean cocorahs) {
        this.cocorahs = cocorahs;
    }

    public String getCocorahsId() {
        return cocorahsId;
    }

    public void setCocorahsId(String cocorahsId) {
        this.cocorahsId = cocorahsId;
    }

    public Boolean getCoop() {
        return coop;
    }

    public void setCoop(Boolean coop) {
        this.coop = coop;
    }

    public String getCoopId() {
        return coopId;
    }

    public void setCoopId(String coopId) {
        this.coopId = coopId;
    }

    public Boolean getHam() {
        return ham;
    }

    public void setHam(Boolean ham) {
        this.ham = ham;
    }

    public String getHamCall() {
        return hamCall;
    }

    public void setHamCall(String hamCall) {
        this.hamCall = hamCall;
    }

    public String getOffice() {
        return this.office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "FirstName:" + firstName + ", LastName:" + lastName + ", Email Address: " + emailAddress1;
    }

}
