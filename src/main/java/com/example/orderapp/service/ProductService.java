package com.example.orderapp.service;

import com.example.orderapp.domain.Product;
import com.example.orderapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //영속성 컨텍스트 변경감지
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //등록
    public Long create(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct.getId();
    }

    //단건 조회
    public Product findById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    //조회
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //수정
    public void update(Long productId, String name, int price) {
        Product product = findById(productId);
        product.setName(name);
        product.setPrice(price);

    }

    // 삭제
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

}
