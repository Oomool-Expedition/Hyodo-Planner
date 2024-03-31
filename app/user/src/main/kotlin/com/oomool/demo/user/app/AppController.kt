package com.oomool.demo.user.app

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal


@RestController
@RequestMapping("/app")
class AppController {

    @GetMapping(path = ["/test"])
    @PreAuthorize("hasAuthority('USER')")
    fun test(principal: Principal): String {
        return principal.name
    }

    @GetMapping(path = ["/test-admin"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun testAdmin(principal: Principal): String {
        return principal.name
    }
}