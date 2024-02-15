package freeapp.life.multimodules.web


import freeapp.life.multimodules.entity.Todo
import freeapp.life.multimodules.service.TodoService
import jakarta.annotation.PostConstruct
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