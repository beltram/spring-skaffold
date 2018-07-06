package io.beltram.pet

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/pets")
class PetResource {

    @GetMapping
    fun hi(): Mono<String> = "I' m a dog".toMono()
}