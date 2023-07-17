package com.issusService.service

import com.issusService.domain.Issus
import com.issusService.domain.IssusRepository
import com.issusService.domain.enums.IssusStatus
import com.issusService.model.IssusRequest
import com.issusService.model.IssusResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class IssusService(private val issusRepository: IssusRepository) {
    @Transactional
    fun create(userId: Long, request: IssusRequest): IssusResponse {
        val issus = Issus(
                userId = userId,
                summary = request.summary,
                description = request.description,
                type = request.type,
                priority = request.priority,
                status = request.status
        )
        return IssusResponse(issusRepository.save(issus))
    }

    @Transactional
    fun getAll(status: IssusStatus) =
            issusRepository.findAllByStatusOrderByCreatedAtDesc(status)
                    ?.map {IssusResponse(it)}


}
