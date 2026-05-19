package com.re.ss5b3.service;


import com.re.ss5b3.model.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product addProduct(Product product);

    Product updateFull(Long id, Product product);

    Product updatePartial(Long id, Map<String, Object> updates);

    boolean deleteProduct(Long id);
}
