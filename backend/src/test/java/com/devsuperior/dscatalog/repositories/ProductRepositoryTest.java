package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    private long existingId;

    private long noExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp(){
        existingId = 1L;
        noExistingId = 1000L;
        countTotalProducts = 25L;
    }

    @Test
    public void findByIdShouldSearchProductWhenIdIsExisting(){
        Optional<Product> product = productRepository.findById(existingId);

        assertTrue(product.isPresent());
    }

    @Test
    public void findByIdNotShouldSearchProductWhenIdIsNotExisting(){
        Optional<Product> product = productRepository.findById(noExistingId);

        assertFalse(product.isPresent());
    }


    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull(){
        Product product = Factory.createProduct();
        product.setId(null);

        product = productRepository.save(product);

        assertNotNull(product.getId());
        assertEquals(countTotalProducts+1, product.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        productRepository.deleteById(existingId);

        Optional<Product> result = productRepository.findById(existingId);

        assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExists(){
        assertThrows(EmptyResultDataAccessException.class,() -> {
            productRepository.deleteById(noExistingId);
        });
    }
}