package com.github.fabriciolfj.product.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.time.LocalDateTime

@Table(name = "Product")
@Entity
data class ProductEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "code")
    val code: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,
    @UpdateTimestamp
    @Column(name = "updated_at")
    val updateAt: LocalDateTime? = null
)