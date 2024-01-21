package gov.noaa.ims.nwsconnect.components.service.strategies;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.notification.Notification;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;
import gov.noaa.ims.nwsconnect.components.service.strategies.interfaces.IssueHandlerStrategy;

@Component
public class CorePartnerLinkStrategy implements IssueHandlerStrategy {
    @Override
    public void handleIssue(CureDetails cureDetails) {

        Notification notification = new Notification("Core Partner registration link sent to " + cureDetails.getContactToBeImported().getEmailAddress1() + "",
                3000,
                Notification.Position.TOP_CENTER);
        notification.getElement().getThemeList().add("success");
        notification.open();

    }
}