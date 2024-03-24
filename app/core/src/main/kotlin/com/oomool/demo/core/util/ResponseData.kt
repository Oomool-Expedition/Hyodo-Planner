package com.oomool.demo.core.util

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseData<T>(
    val status: String = "success",
    val code: Int = 200,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        // 200 OK(success): response data가 없을 때
        fun success() =
            ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    ResponseData(
                        status = "success",
                        code = 200,
                        data = null
                    )
                )

        // 200 OK(success): response data가 있을 때
        fun <T> success(data: T) =
            ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    ResponseData(
                        status = "success",
                        code = 200,
                        data = data
                    )
                )

        // 200 OK(success): response header, data가 있을 때
        fun <T> success(
            header: MultiValueMap<String?, String?>,
            data: T
        ) =
            ResponseEntity
                .status(HttpStatus.OK)
                .header(header.toString())
                .body(
                    ResponseData(
                        status = "success",
                        code = 200,
                        data = data
                    )
                )

        // 400 BAD REQUEST(fail)
        fun fail(
            responseCode: ResponseCode
        ) =
            ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    ResponseData(
                        status = "fail",
                        code = responseCode.httpStatus!!.value(),
                        message = responseCode.detail,
                        data = null
                    )
                )
    }
}
