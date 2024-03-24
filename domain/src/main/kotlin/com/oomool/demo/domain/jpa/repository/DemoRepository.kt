package com.oomool.demo.domain.jpa.repository

import com.oomool.demo.domain.jpa.entity.Demo
import org.springframework.data.jpa.repository.JpaRepository

interface DemoRepository : JpaRepository<Demo, Long> {

}