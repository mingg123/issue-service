package com.issusService.domain.enums

enum class IssusType{
    BUG, TASK;

    companion object{
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
