package io.beltram.pet

enum class RACE {
    CAT, DOG
}

data class Pet(val name: String, val race: RACE, val age: Int) {
}