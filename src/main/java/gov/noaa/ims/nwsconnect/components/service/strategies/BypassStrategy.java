package gov.noaa.ims.nwsconnect.components.service.strategies;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.notification.Notification;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;
import gov.noaa.ims.nwsconnect.components.service.strategies.interfaces.IssueHandlerStrategy;

@Component
public class BypassStrategy implements IssueHandlerStrategy {

    @Override
    public void handleIssue(CureDetails cureDetails) {
        Notification.show("Bypass", 3000, Notification.Position.TOP_CENTER);
    }

}
