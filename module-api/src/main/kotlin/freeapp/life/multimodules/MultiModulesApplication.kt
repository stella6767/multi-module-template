package freeapp.life.multimodules

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("freeapp.life.multimodules")
//@EnableJpaRepositories("freeapp.life.multimodules")
class MultiModulesApplication

fun main(args: Array<String>) {
	runApplication<MultiModulesApplication>(*args)
}
