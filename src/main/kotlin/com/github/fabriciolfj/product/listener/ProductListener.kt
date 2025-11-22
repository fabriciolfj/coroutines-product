package com.github.fabriciolfj.product.listener

import com.github.fabriciolfj.product.model.Product
import com.github.fabriciolfj.product.service.ProductService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service
import tools.jackson.databind.ObjectMapper

@Service
class ProductListener(private val objectMapper: ObjectMapper,
                            private val productService: ProductService) {

    private val logger = KotlinLogging.logger {  }

    @KafkaListener(topics = ["\${topic.product}"])
    suspend fun receive(message: String, acknowledgment: Acknowledgment) {
        logger.info { "receive message $message" }

        try {
            val product = objectMapper.readValue(message, Product::class.java)
            productService.persist(product)

            acknowledgment.acknowledge()
            logger.info { "process successfully message $message" }
        } catch (e: Exception) {
            logger.error { "fail process message $message, details ${e.message}" }
        }
    }
}