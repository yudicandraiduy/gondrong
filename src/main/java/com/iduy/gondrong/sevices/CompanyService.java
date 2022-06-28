package com.iduy.gondrong.sevices;

import com.iduy.gondrong.exception.CommonException;
import com.iduy.gondrong.models.Company;
import com.iduy.gondrong.models.Location;
import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.ErrorMessage;
import com.iduy.gondrong.payload.ErrorSchema;
import com.iduy.gondrong.payload.request.CompanyRequest;
import com.iduy.gondrong.payload.response.CompanyResponse;
import com.iduy.gondrong.repository.CompanyRepository;
import com.iduy.gondrong.repository.LocationRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    public CommonResponse addData(CompanyRequest request) {
        if (repository.existsByCompanyName(request.getCompanyName())) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("Data Already Exist");
            errorMessage.setBahasa("Data Sudah Ada");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setOutputSchema(errorSchema);
            exception.setOutputSchema("");
            throw exception;
        }

        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setServiceOption(request.getServiceOption());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setHoursStart(request.getHoursStart());
        company.setHoursEnd(request.getHoursEnd());
        locationRepository.findById(request.getLocationId()).ifPresent(location -> {
            Set<Location> data = new HashSet<>();
            data.add(location);
            company.setLocations(data);



        });
        userRepository.findById(request.getUserId()).ifPresent(company::setUser);

        company.setImageUrl(request.getImageUrl());
        company.setAreaServed(request.getAreaServed());
        company.setIsActive(true);
        repository.save(company);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Succes add data");
        errorMessage.setBahasa("Berhasil Tambah Data");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(company);
        response.setErrorSchema(errorSchema);
        return response;

    }

    public CommonResponse allDataCompanies(){
        List<Company> dataCompany = repository.findAll();
        if (dataCompany.size() < 1 ){
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("No Data Found");
            errorMessage.setBahasa("Data Tidak Ditemukan");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema(" No Data Found");
            throw exception;

        }

        List<CompanyResponse> responses = new ArrayList<>();
        dataCompany.forEach(company ->{
            CompanyResponse response = new CompanyResponse();
            response.setCompanyName(company.getCompanyName());
            response.setServiceOption(company.getServiceOption());
            response.setAreaServed(company.getAreaServed());
            response.setHoursEnd(company.getHoursEnd());
            response.setHoursStart(company.getHoursStart());
            response.setPhoneNumber(company.getPhoneNumber());
            response.setImageUrl(company.getImageUrl());
            responses.add(response);
        });

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage= new ErrorMessage();
        errorMessage.setEnglish("succes");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(response);
        response.setErrorSchema(errorSchema);
        return response;


//        Company company = new Company();
//        company.setCompanyName(request.getCompanyName());
//        company.setServiceOption(request.getServiceOption());
//        company.setAreaServed(request.getAreaServed());
//        company.setHoursEnd(request.getHoursEnd());
//        company.setHoursStart(request.getHoursStart());
//        company.setPhoneNumber(request.getPhoneNumber());
//        company.setImageUrl(request.getImageUrl());
//        userRepository.findById(request.getUserId()).ifPresent(company::setUser);
//        locationRepository.findById(request.getLocationId()).ifPresent(location -> {
//            Set<Location> data = new HashSet<>();
//            data.add(location);
//            company.setLocations(data);
//        });
    }
}
