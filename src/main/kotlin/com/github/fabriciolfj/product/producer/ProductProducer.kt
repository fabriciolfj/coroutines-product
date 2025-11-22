package com.github.fabriciolfj.product.producer

import com.github.fabriciolfj.product.configuration.KafkaTopicProperties
import com.github.fabriciolfj.product.model.Product
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import tools.jackson.databind.ObjectMapper

@Service
class ProductProducer(private val kafkaTemplate: KafkaTemplate<String, String>,
                            private val properties: KafkaTopicProperties,
                            private val objectMapper: ObjectMapper) {

    private val logger = KotlinLogging.logger {  }

    fun sendMessage(product: Product) {
        val json = objectMapper.writeValueAsString(product)

        kafkaTemplate.send(properties.product, json)
        logger.info { "message send successfully $json" }
    }
}