package com.iduy.gondrong.sevices;

import com.iduy.gondrong.models.Category;
import com.iduy.gondrong.payload.request.CategoryRequest;
import com.iduy.gondrong.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category addData(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return repository.save(category);
    }
}
