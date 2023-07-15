package com.issusService.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.issusService.domain.Issus
import com.issusService.domain.enums.IssusPriority
import com.issusService.domain.enums.IssusStatus
import com.issusService.domain.enums.IssusType
import java.time.LocalDateTime

data class IssusResponse(
        val id: Long,
        val summary: String,
        val description: String,
        val userId: Long,
        val type: IssusType,
        val status: IssusStatus,
        val priority: IssusPriority,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val createdAt: LocalDateTime?,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issus: Issus) = with(issus) {
            IssusResponse(
                    id = id!!,
                    summary = summary,
                    description = description,
                    userId = userId,
                    type = type,
                    status = status,
                    priority = priority,
                    createdAt = createdAt,
                    updatedAt = updatedAt
            )
        }
    }
}
