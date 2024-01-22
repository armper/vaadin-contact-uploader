package gov.noaa.ims.nwsconnect.components.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.vaadin.flow.component.notification.Notification;

import gov.noaa.ims.nwsconnect.components.contactuploader.enums.ContactIssueType;
import gov.noaa.ims.nwsconnect.components.contactuploader.events.CureAppliedEvent;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactDTO;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactIssues;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.ContactList;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.CureDetails;
import gov.noaa.ims.nwsconnect.components.contactuploader.model.Issue;
import gov.noaa.ims.nwsconnect.components.service.strategies.AddAsNonPrimaryContactStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.AddGroupToImsStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.AddOrganizationToImsStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.BypassStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.CorePartnerLinkStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.ImportAsNewContactStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.MergeContactsStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.NoaaEmailIssueHandlerStrategy;
import gov.noaa.ims.nwsconnect.components.service.strategies.interfaces.IssueHandlerStrategy;

@Service
public class ContactCureServiceMock implements ContactIssueProcessor {

        private final Map<ContactIssueType.CureOption, IssueHandlerStrategy> issueStrategies;

        public ContactCureServiceMock(NoaaEmailIssueHandlerStrategy noaaLinkStrategy,
                        ImportAsNewContactStrategy importAsNewContactStrategy,
                        MergeContactsStrategy mergeContactsStrategy,
                        CorePartnerLinkStrategy corePartnerLinkStrategy,
                        AddAsNonPrimaryContactStrategy addAsNonPrimaryContactStrategy,
                        AddOrganizationToImsStrategy addOrganizationToImsStrategy,
                        AddGroupToImsStrategy addGroupToImsStrategy,
                        BypassStrategy bypassStrategy) {
                issueStrategies = new EnumMap<>(ContactIssueType.CureOption.class);
                issueStrategies.put(ContactIssueType.CureOption.SEND_INVITE_LINK_FOR_NOAA, noaaLinkStrategy);
                issueStrategies.put(ContactIssueType.CureOption.SEND_INVITE_LINK_FOR_CORE_PARTNER,
                                corePartnerLinkStrategy);
                issueStrategies.put(ContactIssueType.CureOption.MERGE_CONTACTS, mergeContactsStrategy);
                issueStrategies.put(ContactIssueType.CureOption.IMPORT_AS_NEW_CONTACT, importAsNewContactStrategy);
                issueStrategies.put(ContactIssueType.CureOption.ADD_AS_NON_PRIMARY_CONTACT,
                                addAsNonPrimaryContactStrategy);
                issueStrategies.put(ContactIssueType.CureOption.ADD_ORGANIZATION_TO_IMS,
                                addOrganizationToImsStrategy);
                issueStrategies.put(ContactIssueType.CureOption.ADD_GROUP_TO_IMS, addGroupToImsStrategy);
                issueStrategies.put(ContactIssueType.CureOption.BYPASS, bypassStrategy);
                // Autowire other strategies
        }

        @Override
        public List<ContactIssues> processContacts(ContactList contactList) {
                System.out.println("Mock Processing contacts...");
                System.out.println("Contact List: " + contactList.toString());

                List<ContactIssues> mockContacts = new ArrayList<>();

                // Existing contact to be imported
                ContactDTO contactToBeImportedEmail = createMockContactDTO("Jane", "Doe", "jane.doe@company.com",
                                "123-456-7890");

                // Contact already in the system with different office
                ContactDTO differentOfficeContactEmail = createMockContactDTO("Jane", "Doe", "jane.doe@company.com",
                                "444-456-4322");
                mockContacts.add(createContactIssues(contactToBeImportedEmail, differentOfficeContactEmail,
                                ContactIssueType.EMAIL_ADDRESS_EXISTS_SAME_OFFICE));

                return mockContacts;
        }

        /**
         * Creates a mock ContactIssues object with the given issue type and the
         * given existing contact in the system.
         * 
         * @param contactToBeImported
         *                            The contact to be imported
         * @param existingContact
         *                            The contact already in the system
         */
        private ContactIssues createContactIssues(ContactDTO contactToBeImported, ContactDTO existingContact,
                        ContactIssueType issueType) {
                Issue issue = new Issue(issueType);
                issue.setContactInSystem(existingContact);
                return new ContactIssues(contactToBeImported, Arrays.asList(issue));
        }

        private ContactDTO createMockContactDTO(String firstName, String lastName, String email, String phone) {
                ContactDTO contact = new ContactDTO();
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setEmailAddress1(email);
                contact.setPhoneNumber1(phoneNumberToLong(phone));
                return contact;
        }

        private Long phoneNumberToLong(String phoneNumber) {
                return Long.parseLong(phoneNumber.replace("-", ""));
        }

        @EventListener
        public void onCureAppliedEvent(CureAppliedEvent event) {
                CureDetails cureDetails = event.getCureDetails();

                IssueHandlerStrategy strategy = issueStrategies.get(cureDetails.getSelectedCure());
                if (strategy != null) {
                        strategy.handleIssue(cureDetails);

                        System.out.println("Cure applied: " + cureDetails);
                } else {
                        // No strategy found for the selected cure option
                        Notification.show("No strategy found for cure option: " + cureDetails.getSelectedCure(),
                                        3000, Notification.Position.TOP_CENTER);

                        System.out.println("No strategy found for cure option: " + cureDetails.getSelectedCure());
                }
        }
}
