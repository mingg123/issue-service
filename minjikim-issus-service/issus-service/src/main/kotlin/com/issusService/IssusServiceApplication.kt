package com.issusService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class IssusServiceApplication

fun main(args: Array<String>) {
	runApplication<IssusServiceApplication>(*args)
}
