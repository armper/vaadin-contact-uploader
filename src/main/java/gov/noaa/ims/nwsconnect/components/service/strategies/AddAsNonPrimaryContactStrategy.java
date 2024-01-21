package gov.noaa.ims.nwsconnect.components.service.strategies;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.notification.Notification;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;
import gov.noaa.ims.nwsconnect.components.service.strategies.interfaces.IssueHandlerStrategy;

@Component
public class AddAsNonPrimaryContactStrategy implements IssueHandlerStrategy {

    @Override
    public void handleIssue(CureDetails cureDetails) {
        Notification.show("Add as non-primary contact", 3000, Notification.Position.TOP_CENTER);
    }

}
