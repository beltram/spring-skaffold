package io.beltram.store

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/stores")
class StoreResource {

    @GetMapping
    fun hi() = "I'm a store ".toMono()
}