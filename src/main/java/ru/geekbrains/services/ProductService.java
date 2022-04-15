package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.ProductEntity;
import ru.geekbrains.repositories.ProductRepository;
import ru.geekbrains.soap.products.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public static final Function<ProductEntity, Product> functionEntityToSoap = se -> {
        Product p = new Product();
        p.setId(se.getId());
        p.setName(se.getName());
        p.setCost(se.getCost());
        p.setCategoryTitle(se.getCategories().getTitle());
        return p;
    };

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Product getByName(String name) {
        return productRepository.findByName(name).map(functionEntityToSoap).get();
    }

    public Product getById(Long id) {
      return   productRepository.findById(id).map(functionEntityToSoap).get();
    }
}
