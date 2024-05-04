package com.library.src.member.presentation

import com.library.src.member.application.DeleteMemberService
import com.library.src.member.application.JoinMemberService
import com.library.src.member.application.model.JoinCommand
import com.library.src.member.application.model.JoinResponse
import com.library.src.member.presentation.model.DeleteMemberResponse
import com.library.src.member.presentation.model.JoinMemberRequest
import com.library.src.member.presentation.model.JoinMemberResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MemberController(
        val joinMemberService: JoinMemberService,
        val deleteMemberService: DeleteMemberService
) {

    @PostMapping("/members")
    fun join(@RequestBody req: JoinMemberRequest): ResponseEntity<Any?> {
        val joinResponse: JoinResponse = joinMemberService.joinMember(
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
                JoinMemberResponse(
                        memberId = joinResponse.memberId,
                        name = joinResponse.name,
                        studentId = joinResponse.studentId,
                        grade = joinResponse.grade,
                        "회원가입이 정상적으로 완료되었습니다."
                )
        )
    }

    @DeleteMapping("/members")
    fun delete(@RequestParam(required = true) memberId: String): ResponseEntity<Any> {
        val deleteMemberResponse = deleteMemberService.deleteMember(memberId)

        return ResponseEntity.ok(
                DeleteMemberResponse(
                        deleteMemberResponse.memberId,
                        deleteMemberResponse.name,
                        "회원탈퇴가 정상적으로 완료되었습니다."
                )
        )
    }

}