package freeapp.life.multimodules.api.web



import freeapp.life.multimodules.api.service.TodoService
import freeapp.life.multimodules.storage.entity.Todo
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TodoController(
    private val todoService: TodoService
) {

    private val log = KotlinLogging.logger { }


    @GetMapping("/todos")
    fun findTodos(): MutableList<Todo> {

        return todoService.findTodos()
    }


}