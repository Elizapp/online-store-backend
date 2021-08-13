package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();

    Optional<Category> getCategoryById(Long id);

    Optional<Category> getCategoryByName(String name);

    void createCategory(Category category);
}
