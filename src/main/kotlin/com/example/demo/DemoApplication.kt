package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function
import reactor.core.publisher.Flux

@SpringBootApplication
open class DemoApplication {
	@Bean
	open fun function(): (String) -> String {
		return { it.toUpperCase() }
	}

/*
	@Bean
	fun function(): Function<Flux<String>, Flux<String>> {
		return Function { str: Flux<String> -> str.map { it.toUpperCase() } }
	}
*/
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
