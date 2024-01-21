package gov.noaa.ims.nwsconnect.components.contactuploader.enums;

import java.util.List;
import java.util.Arrays;

public enum ContactIssueType {
    IS_NOAA_EMAIL_ADDRESS("NOAA Gov Email Address Detected",
            Arrays.asList(CureOption.SEND_INVITE_LINK_FOR_NOAA)),
    IS_CORE_PARTNER("Contact is a Core Partner",
            Arrays.asList(CureOption.SEND_INVITE_LINK_FOR_CORE_PARTNER)),
    EMAIL_ADDRESS_EXISTS_OTHER_OFFICE("Email Address Already Exists in System in a Different Office",
            Arrays.asList(CureOption.ADD_AS_NON_PRIMARY_CONTACT, CureOption.IMPORT_AS_NEW_CONTACT)),
    EMAIL_ADDRESS_EXISTS_SAME_OFFICE("Email Address Already Exists in System",
            Arrays.asList(CureOption.MERGE_CONTACTS, CureOption.IMPORT_AS_NEW_CONTACT)),
    PHONE_NUMBER_EXISTS_OTHER_OFFICE("Phone Number Already Exists in System in a Different Office",
            Arrays.asList(CureOption.ADD_AS_NON_PRIMARY_CONTACT, CureOption.IMPORT_AS_NEW_CONTACT)),
    PHONE_NUMBER_EXISTS_SAME_OFFICE("Phone Number Already Exists in System",
            Arrays.asList(CureOption.MERGE_CONTACTS, CureOption.IMPORT_AS_NEW_CONTACT)),
    NO_MATCHING_ORG("Organization Not Found in IMS",
            Arrays.asList(CureOption.ADD_ORGANIZATION_TO_IMS,
                    CureOption.BYPASS)),
    NO_MATCHING_GROUP("Group Not Found in IMS",
            Arrays.asList(CureOption.ADD_GROUP_TO_IMS,
                    CureOption.BYPASS));

    private final String description;
    private final List<CureOption> cureOptions;

    ContactIssueType(String description, List<CureOption> cureOptions) {
        this.description = description;
        this.cureOptions = cureOptions;
    }

    public String getDescription() {
        return description;
    }

    public List<CureOption> getCureOptions() {
        return cureOptions;
    }

    public enum CureOption {
        SEND_INVITE_LINK_FOR_NOAA("Send Invite Link for Registration to a NOAA Email Address"),
        SEND_INVITE_LINK_FOR_CORE_PARTNER("Send Invite Link for Registration to a Core Partner"),
        MERGE_CONTACTS("Merge contacts"),
        IMPORT_AS_NEW_CONTACT("Import as New Contact"),
        ADD_AS_NON_PRIMARY_CONTACT("Add as non-primary contact to current office"),
        ADD_ORGANIZATION_TO_IMS("Add Organization to IMS"),
        ADD_GROUP_TO_IMS("Add Group to IMS"),
        BYPASS("Bypass");

        private final String description;

        CureOption(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

}
