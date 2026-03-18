package com.guelph.engg1420finalprojectjavafx;

import java.util.ArrayList;
import java.util.List;

// Controllers will control these:
// it holds the main list of data for the object/class/type it represents - this case it represents Events***
// Handling creates, edits, and deletes - they edit the main list of data
// This keeps all the logic inside one place without duplicate code
public class EventController {
    private ManageEvent manageEvent; // This list stores all of the events in the system

    public EventController() {
        manageEvent = new ManageEvent();
    }
    // Adds a pre-built Event object directly — used by DataLoader at startup
    public void addEventObject(Event event) {
        manageEvent.addEvent(event);
    }

    /*
    Add a new event to the list of events
     */
    public boolean addEvent(String eventId, String title, String dateTimeStr, String location, String capacityStr, String eventType, String typeSpecificField) {
        Event e = new Event(title, location, Integer.parseInt(capacity));
        eventList.add(e); //We will add an event "e" to the list
    }

    // Parse capacity — return false if not a valid number
    int capacity;
     try {
        capacity = Integer.parseInt(capacityStr);
    } catch (NumberFormatException e) {
        return false;
    }

    /*
    Use a for loop and find the event with the eventId and reset the variables
    When the EventID is equal to the eventId we found, we will set to the following strings/ints
     */
    public void editEvent(int eventId, String title, String location, String capacity, Event.Status stat) {
        for(int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getEventId() == eventId) { //We are basically comparin the EventId in the array to the eventId, when it is equal, we set it to title, location, etc.
                eventList.get(i).setTitle(title);
                eventList.get(i).setLocation(location);
                eventList.get(i).setCapacity(Integer.parseInt(capacity));
                eventList.get(i).setStatus(stat);
                System.out.println("EVENT IS UPDATED " + eventId);
                return; // exit early after update
            }
        }
        System.out.println("NO UPDATED FOR EVENT: " + eventId); //If no update, we will print a line to output nothing is changed
    }
    //
    public ArrayList<Event> getEventList() {
        return eventList; //get the eventList and return the updated list of events
    }

}
