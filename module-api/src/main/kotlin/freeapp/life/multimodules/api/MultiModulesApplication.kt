package freeapp.life.multimodules.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["freeapp.life.multimodules"])
class MultiModulesApplication

fun main(args: Array<String>) {
	runApplication<MultiModulesApplication>(*args)
}
