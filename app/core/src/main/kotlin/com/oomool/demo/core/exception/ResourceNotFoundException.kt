package com.oomool.demo.core.exception

import com.oomool.demo.core.util.ResponseCode

class ResourceNotFoundException : RuntimeException() {
    private val responseCode: ResponseCode? = null
}
