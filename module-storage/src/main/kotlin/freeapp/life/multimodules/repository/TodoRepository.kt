package freeapp.life.multimodules.repository

import com.linecorp.kotlinjdsl.dsl.jpql.jpql
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderer
import freeapp.life.multimodules.domain.Todo
import jakarta.persistence.EntityManager
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {

}


interface TodoCustomRepository


class TodoCustomRepositoryImpl(
    private val em: EntityManager,
    private val renderer: JpqlRenderer,
    private val ctx: JpqlRenderContext
) : TodoCustomRepository {

    fun findTodos() {

        val query = jpql {
            select<Todo>(
                entity(Todo::class),
            ).from(
                entity(Todo::class)
            )
        }

        val render =
            renderer.render(query = query, ctx)

        val jpaQuery = em.createQuery(render.query).apply {
            render.params.forEach { name, value ->
                setParameter(name, value)
            }
        }

        jpaQuery.resultList
    }

}
