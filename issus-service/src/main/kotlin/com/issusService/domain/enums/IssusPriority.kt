package com.issusService.domain.enums

enum class IssusPriority {
    LOW, MEDIUM, HIGH;

    companion object{
        operator fun invoke(type: String) = IssusType.valueOf(type.uppercase())
    }
}
