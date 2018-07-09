package io.beltram.pet

import io.beltram.pet.RACE.DOG
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/pets")
class PetResource {

    @GetMapping
    fun hi() = Pet("Rex", DOG, 5).toMono()
}