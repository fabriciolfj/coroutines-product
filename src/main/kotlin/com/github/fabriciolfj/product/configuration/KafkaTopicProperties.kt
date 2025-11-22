package com.github.fabriciolfj.product.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "topic")
class KafkaTopicProperties {

    var product: String = ""
}