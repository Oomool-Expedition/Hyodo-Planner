package com.oomool.demo.core.util

import org.springframework.http.HttpStatus

enum class ResponseCode(val httpStatus: HttpStatus?, val detail: String?) {
    /* 200 OK : 요청 성공 */

    /* 201 CREATED : 요청 성공, 자원 생성 */

    /* 400 BAD_REQUEST : 잘못된 요청 */

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */

    /* 403 FORBIDDEN : 권한이 없는 사용자 */

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "계정 정보를 찾을 수 없습니다"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */

}