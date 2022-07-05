package com.raphaeldelio.pubsubemulatorexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PubSubEmulatorExampleApplication

fun main(args: Array<String>) {
    runApplication<PubSubEmulatorExampleApplication>(*args)
}
