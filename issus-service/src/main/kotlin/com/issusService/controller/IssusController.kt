package com.issusService.controller

import com.issusService.config.AuthUser
import com.issusService.model.IssusRequest
import com.issusService.service.IssusService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issus")
class IssusController(private val issusService: IssusService) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssusRequest,
    ) = issusService.create(authUser.userId, request)
}