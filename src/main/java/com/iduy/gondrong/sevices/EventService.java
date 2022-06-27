package com.iduy.gondrong.sevices;

import com.iduy.gondrong.exception.CommonException;
import com.iduy.gondrong.models.Event;
import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.ErrorMessage;
import com.iduy.gondrong.payload.ErrorSchema;
import com.iduy.gondrong.payload.request.EventRequest;
import com.iduy.gondrong.payload.response.EventResponse;
import com.iduy.gondrong.repository.EventRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final UserRepository userRepository;

    public EventService(EventRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public CommonResponse allDataEvents() {
        List <Event> dataEvent = repository.findAll();
        if (dataEvent.size()< 1) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("no data found");
            errorMessage.setBahasa(" data tidak ditemukan");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("no found data");
            throw exception;
        }
        List<EventResponse> responses = new ArrayList<>();
        dataEvent.forEach(event -> {
            EventResponse response = new EventResponse();
            response.setId(event.getId());
            response.setUrl(event.getUrl());
            response.setTitle(event.getTitle());
            response.setDate(event.getDate());
            response.setAbout(event.getAbout());
            response.setPlace(event.getPlace());
            response.setEventType(event.getEventType().toString());
            responses.add(response);
        });

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Succes");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(responses);
        response.setErrorSchema(errorSchema);
        return response;
    }




    public CommonResponse addData(EventRequest request){
        if (repository.existsByTitleAndDateAndHost(request.getTitle(), request.getDate(),request.getHost())){
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("Data Already Exist");
            errorMessage.setBahasa("Data Sudah ada");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("");
            throw exception;

        }

        Event event = new Event();
        event.setUrl(request.getUrl());
        event.setTitle(request.getTitle());
        event.setDate(request.getDate());
        event.setAbout(request.getAbout());
        event.setHost(request.getHost());
        event.setEventType(request.getEventType());
        event.setPlace(request.getPlace());
        userRepository.findById(request.getUserId()).ifPresent(event::setUser);
        repository.save(event);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish(" Succes add data");
        errorMessage.setEnglish(" berhasil tambah data");
        errorSchema.setErrorCode(" 000000 ");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(event);
        response.setErrorSchema(errorSchema);
        return response;

    }


}
