package com.github.fabriciolfj.product.mapper

import com.github.fabriciolfj.product.entities.ProductEntity
import com.github.fabriciolfj.product.model.Product

object ProductMapper {

    fun toEntity(product: Product) =
        ProductEntity(
            code = product.id,
            name = product.name
        )
}