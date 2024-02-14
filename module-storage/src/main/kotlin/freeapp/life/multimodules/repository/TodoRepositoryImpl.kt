package freeapp.life.multimodules.repository

import com.linecorp.kotlinjdsl.dsl.jpql.jpql
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderer
import freeapp.life.multimodules.entity.Todo
import freeapp.life.multimodules.repo.TodoRepository
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository



@Repository
class TodoRepositoryImpl(
    private val em: EntityManager,
    private val renderer: JpqlRenderer,
    private val ctx: JpqlRenderContext
) : TodoRepository {

    override fun findTodos(): MutableList<Any?> {

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

        return jpaQuery.resultList
    }

}
