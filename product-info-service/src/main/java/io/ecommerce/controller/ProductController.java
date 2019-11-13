package io.ecommerce.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.ecommerce.model.Product;
import io.ecommerce.Repository.dao.ProductInfo;
import io.ecommerce.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    protected Logger logger = Logger.getLogger(io.ecommerce.controller.ProductController.class.getName());

    @RequestMapping("/{productId}")
//    @HystrixCommand(fallbackMethod = "getDefaultMessage")
    public Product getProductInfo(@PathVariable("productId") String productId) {
        /*throw new RuntimeException("Exception");*/
        return new Product(productId, "Test Product", "Cottons");
    }

    public Product getDefaultMessage() {
        Product product = new Product();
        product.setDesc("Cottons");
        product.setName("ABC");
        product.setProductId("123");
        return product;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<ProductInfo> createProduct(@Valid @RequestBody ProductInfo products) {
        logger.info("products-service createProduct() invoked: " + products);
        ProductInfo productRecord = productInfoService.createProductInfo(products);
        return new ResponseEntity<ProductInfo>(productRecord, new HttpHeaders(), HttpStatus.OK);
    }


}
