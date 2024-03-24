package com.oomool.demo.domain.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "demo")
class Demo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null

) : BaseTimeEntity()