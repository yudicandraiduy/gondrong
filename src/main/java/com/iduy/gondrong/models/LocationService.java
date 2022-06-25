package com.iduy.gondrong.models;

import com.iduy.gondrong.payload.request.LocationRequest;
import com.iduy.gondrong.repository.LocationRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService{

    private final LocationRepository repository;

    private final UserRepository userRepository;


    public LocationService(LocationRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }
    public Location addData(LocationRequest request){
        Location location = new Location();
        location.setAddress(request.getAddress());
        location.setNeighbourhood(request.getNeightbourhood());
        location.setRegency(request.getRegency());
        location.setHamlet(request.getHamlet());
        location.setProvince(request.getProvince());
        location.setPostalCode(request.getPostalCode());
        location.setProvince(request.getProvince());
        location.setVillage(request.getVillage());
        return repository.save(location);




    }


}
