package com.issusService.domain

import com.fasterxml.jackson.databind.ser.Serializers.Base
import com.issusService.domain.enums.IssusPriority
import com.issusService.domain.enums.IssusStatus
import com.issusService.domain.enums.IssusType
import javax.persistence.*

@Entity
@Table
class Issus(
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
    var type: IssusType,

    @Column
    @Enumerated(EnumType.STRING)
    var priority: IssusPriority,

    @Column
    @Enumerated(EnumType.STRING)
    var status: IssusStatus,

) : BaseEntity()