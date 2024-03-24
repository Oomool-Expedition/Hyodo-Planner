package com.oomool.demo.planner.controller.dto

import com.oomool.demo.domain.jpa.entity.Demo

data class DemoResponseDto(
    val id: Long,
    val title: String,
    val content: String?
) {
    companion object {
        fun from(demo: Demo) = DemoResponseDto(
            id = demo.id!!,
            title = demo.title,
            content = demo.content
        )
    }
}