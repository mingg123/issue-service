package com.issusService.domain

import com.issusService.domain.enums.IssuePriority
import com.issusService.domain.enums.IssueStatus
import com.issusService.domain.enums.IssueType
import javax.persistence.*

@Entity
@Table
class Issue(
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

        @Column
    var userId: Long,

        @Column
    var summary: String,

        @Column
    var description: String,

        @Column
    @Enumerated(EnumType.STRING)
    var type: IssueType,

        @Column
    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,

        @Column
    @Enumerated(EnumType.STRING)
    var status: IssueStatus,

        ) : BaseEntity()