package com.issusService.service

import com.issusService.domain.Issue
import com.issusService.domain.IssueRepository
import com.issusService.domain.enums.IssueStatus
import com.issusService.exception.NotFoundException
import com.issusService.model.IssueRequest
import com.issusService.model.IssueResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class IssueService(private val issueRepository: IssueRepository) {
    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {
        val issue = Issue(
                userId = userId,
                summary = request.summary,
                description = request.description,
                type = request.type,
                priority = request.priority,
                status = request.status
        )
        return IssueResponse(issueRepository.save(issue))
    }

    @Transactional
    fun getAll(status: IssueStatus) =
            issueRepository.findAllByStatusOrderByCreatedAtDesc(status)
                    ?.map {IssueResponse(it)}

    @Transactional
    fun get(id: Long): IssueResponse {
        val issus = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("이슈가 존재하지 않습니다.")
        return IssueResponse(issus);
    }

    @Transactional
    fun edit(userId: Long, id: Long, request: IssueRequest) {
        val issue: Issue = issueRepository.findByIdOrNull(id)?: throw NotFoundException("이슈가 존재하지 않습니다.")

        return with(issue) {
            summary = request.summary
            description = request.description
            this.userId = userId
            type = request.type
            priority = request.priority
            status = request.status
            IssueResponse(issueRepository.save(this))
        }
    }

    @Transactional
    fun delete(id: Long) {
        issueRepository.deleteById(id)
    }
}
