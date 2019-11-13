package io.ecommerce.Repository;

import io.ecommerce.Repository.dao.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductInfo, Long> {
    }

