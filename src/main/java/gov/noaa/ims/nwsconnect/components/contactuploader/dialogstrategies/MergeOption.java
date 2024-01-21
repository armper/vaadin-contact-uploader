package gov.noaa.ims.nwsconnect.components.contactuploader.dialogstrategies;

public enum MergeOption {
    KEEP_CONTACT_TO_BE_IMPORTED("Keep contact to be imported"),
    KEEP_CONTACT_IN_SYSTEM("Keep contact in system"),
    CUSTOM_MERGE("Custom merge (choose the fields you wish to import)");

    private final String displayName;

    MergeOption(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}