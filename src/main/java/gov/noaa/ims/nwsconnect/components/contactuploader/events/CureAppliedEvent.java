package gov.noaa.ims.nwsconnect.components.contactuploader.events;

import org.springframework.context.ApplicationEvent;

import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;

public class CureAppliedEvent extends ApplicationEvent {

    private final CureDetails cureDetails;

    /**
     * Constructs a CureAppliedEvent with the specified source and cure details.
     * This event is intended to be consumed by a service responsible for addressing
     * and resolving the specified issues. The CureDetails object provides all the
     * necessary information for the service to apply the appropriate resolution to
     * the issue, such as the type of resolution, the contact's email, and the
     * specific field affected.
     *
     * @param source      The object on which the Event initially occurred or with
     *                    which the Event is associated.
     * @param cureDetails The details of the cure, including the resolution,
     *                    contact's email, and field name.
     */

    public CureAppliedEvent(Object source, CureDetails cureDetails) {
        super(source);
        this.cureDetails = cureDetails;
    }

    public CureDetails getCureDetails() {
        return cureDetails;
    }

    @Override
    public String toString() {
        return "CureAppliedEvent [cureDetails=" + cureDetails + "]";
    }
}