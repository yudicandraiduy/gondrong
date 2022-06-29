package com.iduy.gondrong.sevices;

import com.iduy.gondrong.exception.CommonException;
import com.iduy.gondrong.models.Location;
import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.ErrorMessage;
import com.iduy.gondrong.payload.ErrorSchema;
import com.iduy.gondrong.payload.request.LocationRequest;
import com.iduy.gondrong.payload.response.LocationResponse;
import com.iduy.gondrong.repository.LocationRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService{


    private final LocationRepository repository;


    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }



    public CommonResponse addData(LocationRequest request) {
        if (repository.existsByAddressAndRegency(request.getAddress(), request.getRegency())) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("Data Already Exist");
            errorMessage.setBahasa(" Data Sudah Ada");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("");
            throw exception;
        }


        Location location = new Location();
        location.setAddress(request.getAddress());
        location.setNeighbourhood(request.getNeighbourhood());
        location.setRegency(request.getRegency());
        location.setHamlet(request.getHamlet());
        location.setProvince(request.getProvince());
        location.setPostalCode(request.getPostalCode());
        location.setProvince(request.getProvince());
        location.setVillage(request.getVillage());
        repository.save(location);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish(" Succes Tambah Data");
        errorMessage.setBahasa("Berhasil Tambah Data");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(location);
        response.setErrorSchema(errorSchema);
        return response;
    }
    public CommonResponse allDataLocations() {
        List<Location> dataLocation = repository.findAll();
        if (dataLocation.size() < 1) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("No Data Found");
            errorMessage.setBahasa(" Data Tidak Ditemukan ");
            errorSchema.setErrorCode("000000");
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("No Data Found");
            throw exception;

        }
        List<LocationResponse> responses = new ArrayList<>();
        dataLocation.forEach(location -> {
            LocationResponse response = new LocationResponse();
            response.setAddress(location.getAddress());
            response.setId(location.getId());
            response.setNeighbourhood(location.getNeighbourhood());
            response.setHamlet(location.getHamlet());
            response.setVillage(location.getVillage());
            response.setSubDistrct(location.getSubDistrict());
            response.setProvince(location.getProvince());
            response.setRegency(location.getRegency());
            responses.add(response);
        });
        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("succes");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(response);
        response.setErrorSchema(errorSchema);
        return response;
    }
    }







