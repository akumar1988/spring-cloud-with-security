package io.ecommerce.service.impl;

import io.ecommerce.Repository.ProductsRepository;
import io.ecommerce.Repository.dao.ProductInfo;
import io.ecommerce.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductsRepository productRepository;

    public ProductInfo createProductInfo(ProductInfo entity) {
        Optional<ProductInfo> product = productRepository.findById(entity.getId());
        if (product.isPresent()) {
            ProductInfo productDetails = product.get();
            productDetails.setName(entity.getName());
            productDetails.setBrand(entity.getBrand());
            productDetails.setColor(entity.getColor());
            productDetails.setPrice(entity.getPrice());
            productDetails.setSize(entity.getSize());
            productDetails.setStore(entity.getStore());
            productDetails = productRepository.save(productDetails);
            return productDetails;
        } else {
            entity = productRepository.save(entity);
            System.out.println(entity);
            return entity;
        }
    }
}
