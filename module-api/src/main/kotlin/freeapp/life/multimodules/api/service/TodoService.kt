package freeapp.life.multimodules.api.service


import freeapp.life.multimodules.storage.entity.Todo
import freeapp.life.multimodules.storage.repository.TodoRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service


@Service
class TodoService(
    private val todoRepository: TodoRepository
) {

    @PostConstruct
    fun saveTodos() {
//        val todo1 = Todo(
//            content = "test1",
//            status = false
//        )
//
//        val todo2 = Todo(
//            content = "test1",
//            status = false
//        )
//
//        todoRepository.saveAll(listOf(todo1, todo2))

    }

    fun findTodos(): MutableList<Todo> {
        return todoRepository.findTodos()
    }


}