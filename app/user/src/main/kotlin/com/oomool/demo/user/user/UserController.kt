package com.oomool.demo.user.user

import com.google.firebase.auth.FirebaseAuthException
import com.oomool.demo.user.security.Permission
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class UserController(private val userService: UserService) {

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/user-claims/{uid}")
    @Throws(FirebaseAuthException::class)
    fun setUserClaims(
            @PathVariable uid: String?,
            @RequestBody requestedClaims: List<Permission>?
    ) {

        userService.setUserClaims(uid, requestedClaims.orEmpty())
    }
}