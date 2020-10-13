package me.jacoblewis.evco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EvcoApplication

fun main(args: Array<String>) {
	runApplication<EvcoApplication>(*args)
}
