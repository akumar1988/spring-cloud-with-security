package com.authorization.controller;

import com.authorization.model.CatalogItem;
import com.authorization.model.Product;
import com.authorization.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class ProductCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<CatalogItem> getCatalog(@RequestHeader  @PathVariable("userId") String userId) {
        /*WebClient.Builder builder = WebClient.builder();*/
        UserRating ratings = restTemplate.getForObject("http://product-rating-service/ratingsdata/users/"+userId, UserRating.class);
        return ratings.getUserRating().stream().map(rating -> {
            Product product = restTemplate.getForObject("http://product-info-service/product/"+rating.getProductId(), Product.class);
            return new CatalogItem(product.getName(), product.getDesc(), rating.getRating());
        })
                .collect(Collectors.toList());
    }
        /*@Autowired
    private WebClient.Builder builder;
    Cloth cloth = builder.build()
                    .get()
                    .uri("http://localhost:8081/cloths/" + rating.getClothId(), Cloth.class)
                    .retrieve()
                    .bodyToMono(Cloth.class)
                    .block();*/
}


