package com.library.src.member.presentation

import com.library.src.member.application.JoinMemberService
import com.library.src.member.application.model.JoinCommand
import com.library.src.member.application.model.JoinMemberResponse
import com.library.src.member.presentation.model.JoinMemberRequest
import com.library.src.member.presentation.model.MemberResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class MemberController(
    val joinMemberService: JoinMemberService
) {

    @PostMapping("/members/join")
    fun join(@RequestBody req: JoinMemberRequest): ResponseEntity<Any?> {
        val joinMemberResponse: JoinMemberResponse = joinMemberService.joinMember(
            JoinCommand(
                req.memberId,
                req.password,
                req.email,
                req.name,
                req.studentId,
                req.grade

            )
        )

        return ResponseEntity.ok(
            MemberResponse(
                memberId = joinMemberResponse.memberId,
                grade = joinMemberResponse.grade,
                name = joinMemberResponse.name,
                studentId = joinMemberResponse.studentId,
                message = "회원가입에 성공했습니다."
            )
        )
    }

}