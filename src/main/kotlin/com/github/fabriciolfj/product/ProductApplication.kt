package com.github.fabriciolfj.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.github.fabriciolfj.product.repositories"])
@EnableJpaAuditing
@EnableKafka
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
