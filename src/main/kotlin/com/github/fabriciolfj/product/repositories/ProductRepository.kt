package com.github.fabriciolfj.product.repositories

import com.github.fabriciolfj.product.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<ProductEntity, Long>