package com.example.orderapp.controller;

import com.example.orderapp.domain.Product;
import com.example.orderapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //등록
    @PostMapping
    public Long create(@RequestBody Product product) {
        return productService.create(product);
    }

    //단건 조회
    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    //수정
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Product product) {
        productService.update(id, product.getName(), product.getPrice());
    }

    //삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
