package com.devsuperior.dscatalog.tests;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct(){
        Category cat = createCategory();
        Product product = new Product(1L,"Phone", "Good Phone", 800.0
                , "https://img.com/img.png", Instant.parse("2022-08-10T14:53:00Z"));
        product.getCategories().add(cat);
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category createCategory(){
        return new Category(4L,"Electronics",Instant.now(),Instant.now(),null);
    }
}
