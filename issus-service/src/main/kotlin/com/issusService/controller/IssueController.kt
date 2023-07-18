package com.issusService.controller

import com.issusService.config.AuthUser
import com.issusService.domain.enums.IssueStatus
import com.issusService.model.IssueRequest
import com.issusService.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issue")
class IssueController(private val issueService: IssueService) {

    @PostMapping
    fun create(
            authUser: AuthUser,
            @RequestBody request: IssueRequest,
    ) = issueService.create(authUser.userId, request)

    @GetMapping
    fun getAll(
            authUser: AuthUser,
            @RequestParam(required = false, defaultValue = "TODO") status: IssueStatus,
    ) = issueService.getAll(status)

    @GetMapping("/{id}")
    fun getDetail(
            authUser: AuthUser,
            @PathVariable id: Long
    ) = issueService.get(id);

    @PutMapping("/{id}")
    fun edit(
            authUser: AuthUser,
            @PathVariable id: Long,
            @RequestBody issusRequest: IssueRequest,
    ) = issueService.edit(authUser.userId, id, issusRequest);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
            authUser: AuthUser,
            @PathVariable id: Long
    ) = issueService.delete(id)
}