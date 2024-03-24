package com.oomool.demo.planner

import com.oomool.demo.core.CoreBase
import com.oomool.demo.domain.DomainBase
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(
	basePackageClasses = [
		PlannerApplicationBase::class,
		DomainBase::class,
		CoreBase::class,
	],
)
@EntityScan(basePackageClasses = [DomainBase::class])
@EnableJpaRepositories(basePackageClasses = [DomainBase::class])
@EnableJpaAuditing
class PlannerApplication

fun main(args: Array<String>) {
	runApplication<PlannerApplication>(*args)
}
