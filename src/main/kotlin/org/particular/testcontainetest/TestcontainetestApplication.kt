package org.particular.testcontainetest

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("org.particular")
@EnableAutoConfiguration
class TestcontainetestApplication

fun main(args: Array<String>) {
	runApplication<TestcontainetestApplication>(*args)
}
