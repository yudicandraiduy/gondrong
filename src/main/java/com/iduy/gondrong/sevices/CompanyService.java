package com.iduy.gondrong.sevices;

import com.iduy.gondrong.models.Company;
import com.iduy.gondrong.models.Location;
import com.iduy.gondrong.payload.request.CompanyRequest;
import com.iduy.gondrong.repository.CompanyRepository;
import com.iduy.gondrong.repository.LocationRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;


    public CompanyService(CompanyRepository repository, UserRepository userRepository, LocationRepository locationRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }
    public Company addData (CompanyRequest request){
        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setServiceOption(request.getServiceOption());
        company.setAreaServed(request.getAreaServed());
        company.setHoursEnd(request.getHoursEnd());
        company.setHoursStart(request.getHoursStart());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setImageUrl(request.getImageUrl());
        userRepository.findById(request.getUserId()).ifPresent(company::setUser);
        locationRepository.findById(request.getLocationId()).ifPresent(location -> {
            Set<Location> data = new HashSet<>();
            data.add(location);
            company.setLocations(data);
        });

       return repository.save(company);


    }
}
