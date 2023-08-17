package com.auth.study.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignUpRequest(
        @Schema(description = "회원 아이디", example = "example1234")
        String account,
        @Schema(description = "회원 비밀번호", example = "1234")
        String password,
        @Schema(description = "회원 이름", example = "홍길동")
        String name,
        @Schema(description = "회원 나이", example = "24")
        Integer age
) {
}
