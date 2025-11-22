package com.github.fabriciolfj.product.controller

import com.github.fabriciolfj.product.model.Product
import com.github.fabriciolfj.product.service.ProductService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {

    private val logger = KotlinLogging.logger {}

    @PostMapping
    fun createProduct(@RequestBody product: Product) {
        logger.info { "receive paylod $product" }
        productService.process(product)
    }
}