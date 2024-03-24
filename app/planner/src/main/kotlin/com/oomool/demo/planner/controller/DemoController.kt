package com.oomool.demo.planner.controller

import com.oomool.demo.planner.controller.dto.DemoRequestDto
import com.oomool.demo.planner.controller.dto.DemoResponseDto
import com.oomool.demo.planner.service.DemoService
import com.oomool.demo.core.util.ResponseData
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("v1/demo")
class DemoController(
    private val demoService: DemoService
) {

    @PostMapping
    fun createDemo(
        @RequestBody @Valid demoRequestDto: DemoRequestDto
    ): ResponseEntity<ResponseData<DemoResponseDto>> {
        val result = demoService.createDemo(demoRequestDto)
        return ResponseData.success(result)
    }

    @GetMapping
    fun getDemos() = ResponseData.success(demoService.getDemos())

    @GetMapping("{id}")
    fun getDemo(@PathVariable id: Long) = ResponseData.success(demoService.getDemo(id))
}