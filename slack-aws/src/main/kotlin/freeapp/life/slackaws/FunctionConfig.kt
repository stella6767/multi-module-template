package freeapp.life.slackaws

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FunctionConfig {


    @Bean
    fun reverse(): (String) -> String {

        val function = { s: String ->
            StringBuilder(s).reverse().toString()
        }

        return function
    }


}