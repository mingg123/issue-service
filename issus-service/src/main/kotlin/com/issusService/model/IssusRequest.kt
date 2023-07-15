package com.issusService.model

import com.issusService.domain.enums.IssusPriority
import com.issusService.domain.enums.IssusStatus
import com.issusService.domain.enums.IssusType

data class IssusRequest (
        val summary: String,
        val description: String,
        val type: IssusType,
        val status: IssusStatus,
        val priority: IssusPriority
)