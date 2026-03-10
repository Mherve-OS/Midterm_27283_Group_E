package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Event;
import com.herve.talentbooking.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Page<Event> getAllEvents(int page, int size) {
        return eventRepository.findAll(PageRequest.of(page, size));
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Long id, Event event) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existing.setTitle(event.getTitle());
        existing.setLocation(event.getLocation());
        existing.setEventDate(event.getEventDate());
        existing.setDescription(event.getDescription());
        if (event.getClient() != null) {
            existing.setClient(event.getClient());
        }
        return eventRepository.save(existing);
    }
}