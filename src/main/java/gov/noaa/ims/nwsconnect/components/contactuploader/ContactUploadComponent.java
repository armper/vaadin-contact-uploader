package gov.noaa.ims.nwsconnect.components.contactuploader;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.shared.Registration;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ContactUploadComponent extends Div {

    private static final List<String> ACCEPTED_FILE_TYPES = Arrays.asList("application/json");

    public ContactUploadComponent() {
        createUploadComponent();
    }

    public static class FileUploadedEvent extends ComponentEvent<ContactUploadComponent> {
        private final InputStream fileContent;

        public FileUploadedEvent(ContactUploadComponent source, InputStream fileContent) {
            super(source, false);
            this.fileContent = fileContent;
        }

        public InputStream getFileContent() {
            return fileContent;
        }
    }

    private void createUploadComponent() {
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setAcceptedFileTypes(ACCEPTED_FILE_TYPES.toArray(new String[0]));
        upload.setMaxFiles(1);
        upload.addSucceededListener(event -> processFile(event.getMIMEType()));

        upload.addSucceededListener(event -> {
            InputStream fileContent = buffer.getInputStream();

            fireEvent(new FileUploadedEvent(this, fileContent));

            upload.clearFileList();
        });

        this.add(upload);
    }

    private void processFile(String mimeType) {
        if (mimeType.equals("application/json")) {
            Notification.show("JSON file uploaded successfully.");
        }
    }

    public Registration addFileUploadedListener(ComponentEventListener<FileUploadedEvent> listener) {
        return addListener(FileUploadedEvent.class, listener);
    }

}
