package com.issusService.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.issusService.domain.Issue
import com.issusService.domain.enums.IssuePriority
import com.issusService.domain.enums.IssueStatus
import com.issusService.domain.enums.IssueType
import java.time.LocalDateTime

data class IssueResponse(
        val id: Long,
        val summary: String,
        val description: String,
        val userId: Long,
        val type: IssueType,
        val status: IssueStatus,
        val priority: IssuePriority,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val createdAt: LocalDateTime?,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issue: Issue) = with(issue) {
            IssueResponse(
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
