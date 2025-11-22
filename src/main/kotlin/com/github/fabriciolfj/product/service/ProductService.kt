package com.github.fabriciolfj.product.service

import com.github.fabriciolfj.product.mapper.ProductMapper
import com.github.fabriciolfj.product.mapper.ProductMapper.toEntity
import com.github.fabriciolfj.product.model.Product
import com.github.fabriciolfj.product.producer.ProductProducer
import com.github.fabriciolfj.product.repositories.ProductRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productProducer: ProductProducer,
                          private val productRepository: ProductRepository) {

    fun process(product: Product) {
        productProducer.sendMessage(product)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    suspend fun persist(product: Product) = coroutineScope {
        launch {
            processPersist(product)
        }

    }

    private fun processPersist(product: Product) {
        toEntity(product)
            .also {
                productRepository.saveAndFlush(it)
            }
    }
}