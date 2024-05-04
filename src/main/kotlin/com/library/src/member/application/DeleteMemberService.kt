package com.library.src.member.application

import com.library.src.common.exception.NotFoundMemberException
import com.library.src.member.application.model.DeleteResponse
import com.library.src.member.domain.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DeleteMemberService(
        private val memberRepository: MemberRepository
) {
    @Transactional
    fun deleteMember(memberId: String): DeleteResponse {
        val findMemberByMemberId = memberRepository.findMemberByMemberId(memberId)
                ?: throw NotFoundMemberException()

        memberRepository.delete(findMemberByMemberId)
        return DeleteResponse(
                memberId = findMemberByMemberId.memberId,
                name = findMemberByMemberId.name
        )
    }
}