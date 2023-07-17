package com.issusService.domain

import com.issusService.domain.enums.IssusStatus
import org.springframework.data.jpa.repository.JpaRepository

interface IssusRepository: JpaRepository<Issus, Long> {
    fun findAllByStatusOrderByCreatedAtDesc(status: IssusStatus): List<Issus>?
}