package com.issusService.service

import com.issusService.domain.Issus
import com.issusService.domain.IssusRepository
import com.issusService.domain.enums.IssusStatus
import com.issusService.exception.NotFoundException
import com.issusService.model.IssusRequest
import com.issusService.model.IssusResponse
import org.springframework.data.repository.findByIdOrNull
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

    @Transactional
    fun get(id: Long): IssusResponse {
        val issus = issusRepository.findByIdOrNull(id) ?: throw NotFoundException("이슈가 존재하지 않습니다.")
        return IssusResponse(issus);
    }

    @Transactional
    fun edit(userId: Long, id: Long, request: IssusRequest) {
        val issus: Issus = issusRepository.findByIdOrNull(id)?: throw NotFoundException("이슈가 존재하지 않습니다.")

        return with(issus) {
            summary = request.summary
            description = request.description
            this.userId = userId
            type = request.type
            priority = request.priority
            status = request.status
            IssusResponse(issusRepository.save(this))
        }
    }

    @Transactional
    fun delete(id: Long) {
        issusRepository.deleteById(id)
    }
}
