package freeapp.life.multimodules.config

import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderer
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JDSLConfig(
    private val entityManager: EntityManager
) {

    @Bean
    fun jpqlRenderContext(): JpqlRenderContext {
        return JpqlRenderContext()
    }

    @Bean
    fun jpqlRenderer(): JpqlRenderer {
        return JpqlRenderer()
    }
}