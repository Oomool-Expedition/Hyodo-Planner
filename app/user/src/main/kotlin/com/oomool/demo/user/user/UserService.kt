package com.oomool.demo.user.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.oomool.demo.user.security.Permission
import org.springframework.stereotype.Service

@Service
class UserService(private val firebaseAuth: FirebaseAuth) {

    @Throws(FirebaseAuthException::class)
    fun setUserClaims(uid: String?, requestedPermissions: List<Permission>) {
        val permissions = requestedPermissions.map { it.toString() }
        val claims = mapOf("custom_claims" to permissions)
        firebaseAuth.setCustomUserClaims(uid, claims)
    }
}