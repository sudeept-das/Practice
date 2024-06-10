package org.example.publisher;

import org.example.interfaces.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPublisher {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventPublisher(String... operations){
        for(String operation: operations)
            listeners.put(operation, new ArrayList<>());
    }

    public void subscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);
        for(EventListener user: users)
            user.update(eventType, file);
    }
}
