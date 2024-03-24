package com.oomool.demo.planner.controller.dto

import com.oomool.demo.domain.jpa.entity.Demo

data class DemoRequestDto(
    val title: String,
    val content: String?
) {
    fun toDemo() = Demo(
        title = title,
        content = content
    )
}