package freeapp.life.multimodules.storage.repository

import com.linecorp.kotlinjdsl.dsl.jpql.jpql
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderer
import freeapp.life.multimodules.storage.entity.Todo

import jakarta.persistence.EntityManager
import org.springframework.data.jpa.repository.JpaRepository


interface TodoRepository : JpaRepository<Todo, Long>, TodoCustomRepository


interface TodoCustomRepository {
    fun findTodos(): MutableList<Todo>
}

class TodoCustomRepositoryImpl (
    private val em: EntityManager,
    private val renderer: JpqlRenderer,
    private val ctx: JpqlRenderContext
) : TodoCustomRepository {

    override fun findTodos(): MutableList<Todo> {

        val query = jpql {
            select<Todo>(
                entity(Todo::class),
            ).from(
                entity(Todo::class)
            )
        }

        val render =
            renderer.render(query = query, ctx)

        val jpaQuery = em.createQuery(render.query, Todo::class.java).apply {
            render.params.forEach { name, value ->
                setParameter(name, value)
            }
        }

        return jpaQuery.resultList
    }

}
