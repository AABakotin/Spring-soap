package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.CategoriesEntity;
import ru.geekbrains.repositories.CategoriesRepository;
import ru.geekbrains.soap.categories.Category;

import java.util.function.Function;



@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public static final Function<CategoriesEntity, Category> functionEntityToSoap = ge -> {
        Category c = new Category();
        c.setTitle(ge.getTitle());
        ge.getProducts().stream().map(ProductService.functionEntityToSoap).forEach(p -> c.getProducts().add(p));
        return c;
    };

    public Category getByTitle(String title) {
        return categoriesRepository.findByTitle(title).map(functionEntityToSoap).get();
    }
}
