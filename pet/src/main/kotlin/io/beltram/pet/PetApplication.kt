package io.beltram.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetApplication

fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}
