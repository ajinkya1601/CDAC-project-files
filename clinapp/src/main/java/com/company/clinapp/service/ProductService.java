package com.company.clinapp.service;

import com.company.clinapp.dao.ProductRepository;
import com.company.clinapp.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public String delete(Long id){
        if (getProduct(id).isPresent()) {
            productRepository.deleteById(id);
            return "Product with id " + id + " is deleted!";
        } else
            return "Employee with id " + id + " not found";
    }

    public Product update(Product product){
        return productRepository.save(product);
    }
}
