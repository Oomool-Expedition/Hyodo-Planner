package com.oomool.demo.planner.service

import com.oomool.demo.domain.jpa.repository.DemoRepository
import com.oomool.demo.planner.controller.dto.DemoRequestDto
import com.oomool.demo.planner.controller.dto.DemoResponseDto
import org.springframework.stereotype.Service

@Service
class DemoService(
    private val demoRepository: DemoRepository
) {
    fun createDemo(demoRequestDto: DemoRequestDto): DemoResponseDto {
        val demo = demoRepository.save(demoRequestDto.toDemo())
        return DemoResponseDto.from(demo)
    }

    fun getDemos() = demoRepository.findAll().map(DemoResponseDto::from)

    fun getDemo(id: Long) = DemoResponseDto.from(demoRepository.findById(id).orElseThrow())
}