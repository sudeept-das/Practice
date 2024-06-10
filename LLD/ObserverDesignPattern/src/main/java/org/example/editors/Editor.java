package org.example.editors;

import org.example.publisher.EventPublisher;

import java.io.File;

public class Editor {
    public EventPublisher events;
    private File file;

    public Editor() {
        this.events = new EventPublisher("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
