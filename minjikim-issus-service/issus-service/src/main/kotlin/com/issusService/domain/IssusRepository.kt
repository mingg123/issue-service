package com.issusService.domain

import org.springframework.data.jpa.repository.JpaRepository

interface IssusRepository: JpaRepository<Issus, Long> {
}