package com.guelph.engg1420finalprojectjavafx;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ManageEvent {
    private ArrayList<Event> eventList;

    public ManageEvent() {
        this.eventList = new ArrayList<>();
    }

    // Adds a new event — returns false if event ID already exists
    public boolean addEvent(Event newEvent) {
        for (Event event : this.eventList) {
            if (event.getEventId().equalsIgnoreCase(newEvent.getEventId())) {
                return false; // duplicate ID
            }
        }
        this.eventList.add(newEvent);
        return true;
    }

    // Updates an existing event's fields — returns false if event not found or capacity invalid
    public boolean updateEvent(String eventId, String newTitle, LocalDateTime newDateTime,
                               String newLocation, int newCapacity, String newField) {

        // Capacity must be greater than 0
        if (newCapacity <= 0) {
            return false;
        }

        for (Event event : this.eventList) {
            if (event.getEventId().equalsIgnoreCase(eventId)) {
                event.setTitle(newTitle);
                event.setDate(newDateTime);
                event.setLocation(newLocation);
                event.setCapacity(newCapacity);
                event.updateTypeSpecificField(newField);
                return true;
            }
        }

        return false; // event not found
    }

    // Cancels an event and all its bookings/waitlist
    public boolean cancelEvent(String eventId, ManageBooking manageBooking, Waitlist waitlist) {
        for (Event event : this.eventList) {
            if (event.getEventId().equalsIgnoreCase(eventId)) {
                event.cancelEvent(manageBooking, waitlist);
                return true;
            }
        }
        return false; // event not found
    }

    // Returns a copy of all events
    public ArrayList<Event> listEvents() {
        return new ArrayList<>(eventList);
    }

    // Searches events by partial, case-insensitive title match
    public ArrayList<Event> searchEvent(String title) {
        ArrayList<Event> res = new ArrayList<Event>();
        String query = title.toLowerCase();

        for (Event event : eventList) {
            String eventTitle = event.getTitle().toLowerCase();
            if (eventTitle.contains(query)) {
                res.add(event);
            }
        }

        return res;
    }

    // Finds and returns an event by its ID
    public Event getEventById(String eventId) {
        for (Event event : eventList) {
            if (event.getEventId().equalsIgnoreCase(eventId)) {
                return event;
            }
        }
        return null; // not found
    }

    // Returns all events of a given type (Workshop, Seminar, or Concert)
    public ArrayList<Event> filterByType(String type) {
        ArrayList<Event> res = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getClass().getSimpleName().equalsIgnoreCase(type)) {
                res.add(event);
            }
        }
        return res;
    }
}
