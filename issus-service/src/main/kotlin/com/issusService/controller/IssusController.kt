package com.issusService.controller

import com.issusService.config.AuthUser
import com.issusService.domain.enums.IssusStatus
import com.issusService.model.IssusRequest
import com.issusService.service.IssusService
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
@RequestMapping("/api/v1/issus")
class IssusController(private val issusService: IssusService) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssusRequest,
    ) = issusService.create(authUser.userId, request)

    @GetMapping
    fun getAll(
            authUser: AuthUser,
            @RequestParam(required = false, defaultValue = "TODO") status: IssusStatus,
    ) = issusService.getAll(status)

    @GetMapping("/{id}")
    fun getDetail(
            authUser: AuthUser,
            @PathVariable id: Long
    ) = issusService.get(id);

    @PutMapping("/{id}")
    fun edit(
            authUser: AuthUser,
            @PathVariable id: Long,
            @RequestBody issusRequest: IssusRequest,
    ) = issusService.edit(authUser.userId, id, issusRequest);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
            authUser: AuthUser,
            @PathVariable id: Long
    ) = issusService.delete(id)
}