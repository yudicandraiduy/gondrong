package com.iduy.gondrong.sevices;

import com.iduy.gondrong.exception.CommonException;
import com.iduy.gondrong.models.Category;
import com.iduy.gondrong.payload.CommonResponse;
import com.iduy.gondrong.payload.ErrorMessage;
import com.iduy.gondrong.payload.ErrorSchema;
import com.iduy.gondrong.payload.request.CategoryRequest;
import com.iduy.gondrong.payload.response.CategoryResponse;
import com.iduy.gondrong.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CommonResponse addData(CategoryRequest request){
        if (repository.existsByNameAndEntityName(request.getName(), request.getEntityName())) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("Data Already Exist");
            errorMessage.setBahasa("Data Sudah Ada");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("");
            throw exception;
        }

        Category category = new Category();
        category.setName(request.getName());
        category.setEntityName(request.getEntityName());
        category.setIsActive(true);
        repository.save(category);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Success Add Data");
        errorMessage.setBahasa("Berhasil Tambah Data");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(category);
        response.setErrorSchema(errorSchema);
        return response;
    }

    public CommonResponse allDataCategories() {
        List<Category> dataCategory = repository.findAllByIsActive(true);
        if (dataCategory.size() < 1) {
            CommonException exception = new CommonException();
            ErrorSchema errorSchema = new ErrorSchema();
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setEnglish("No Data Found");
            errorMessage.setBahasa("Data Tidak Ditemukan");
            errorSchema.setErrorCode("000000");
            errorSchema.setErrorMessage(errorMessage);
            exception.setErrorSchema(errorSchema);
            exception.setOutputSchema("No Data Found");
            throw exception;
        }

        List<CategoryResponse> responses = new ArrayList<>();
        dataCategory.forEach(category -> {
            CategoryResponse response = new CategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            response.setEntityName(category.getEntityName());
            responses.add(response);
        });

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setEnglish("Success");
        errorMessage.setBahasa("Berhasil");
        errorSchema.setErrorCode("000000");
        errorSchema.setErrorMessage(errorMessage);

        CommonResponse response = new CommonResponse();
        response.setOutputSchema(responses);
        response.setErrorSchema(errorSchema);
        return response;
    }
}
