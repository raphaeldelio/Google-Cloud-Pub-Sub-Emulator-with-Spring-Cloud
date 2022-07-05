package com.raphaeldelio.pubsubemulatorexample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import java.util.function.Consumer
import java.util.function.Supplier
import kotlin.random.Random

@Configuration
class SumNumbersConfiguration {

    @Bean
    fun generateNumbers(): Supplier<Message<String>> = Supplier<Message<String>> {
        val randomNumber1 = Random.nextInt(100)
        val randomNumber2 = Random.nextInt(100)

        print("$randomNumber1+$randomNumber2=")

        MessageBuilder.withPayload(
            "$randomNumber1,$randomNumber2"
        ).build()
    }

    @Bean
    fun sumNumbers(): Consumer<Message<*>> = Consumer<Message<*>> { message ->
        val decodedMessage = (message.payload as ByteArray).decodeToString()

           println(
               decodedMessage.split(",")
               .fold(0) { total, item -> total + item.toInt() }
           )
        }

}