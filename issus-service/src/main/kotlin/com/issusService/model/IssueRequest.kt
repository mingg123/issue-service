package com.issusService.model

import com.issusService.domain.enums.IssuePriority
import com.issusService.domain.enums.IssueStatus
import com.issusService.domain.enums.IssueType

data class IssueRequest (
        val summary: String,
        val description: String,
        val type: IssueType,
        val status: IssueStatus,
        val priority: IssuePriority
)