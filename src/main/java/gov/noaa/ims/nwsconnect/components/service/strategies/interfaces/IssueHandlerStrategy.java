package gov.noaa.ims.nwsconnect.components.service.strategies.interfaces;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

public interface IssueHandlerStrategy {
    void handleIssue(CureDetails cureDetails);
}
