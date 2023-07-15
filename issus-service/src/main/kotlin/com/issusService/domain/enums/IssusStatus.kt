package com.issusService.domain.enums

enum class IssusStatus {
    TODO, IN_PROGRESS, RESOLVED;
    companion object{
        operator fun invoke(type: String) = IssusType.valueOf(type.uppercase())
    }
}