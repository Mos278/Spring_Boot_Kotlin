package com.server.kotlinTest.Entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
open class BaseEntity {
    @Id
    @GeneratedValue()
    @Column(name = "code", nullable = false)
    open var code: Long? = null

}