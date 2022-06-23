package com.iduy.gondrong.sevices;

import com.iduy.gondrong.models.Event;
import com.iduy.gondrong.payload.request.EventRequest;
import com.iduy.gondrong.repository.EventRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository repository;
    private final UserRepository userRepository;

    public EventService(EventRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Event addData(EventRequest request){
        Event event = new Event();
        event.setUrl(request.getUrl());
        event.setTitle(request.getTitle());
        event.setDate(request.getDate());
        event.setAbout(request.getAbout());
        event.setHost(request.getHost());
        event.setEventType(request.getEventType());
        event.setPlace(request.getPlace());
        userRepository.findById(request.getUserId()).ifPresent(event::setUser);
        return repository.save(event);
    }

}
