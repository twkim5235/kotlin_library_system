package com.library.src.member.application

import com.library.src.member.domain.MemberRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DeleteMemberServiceTest(
        @Autowired
        val memberRepository: MemberRepository
){
    @Test
    fun deleteMemberTest() {
        val findMemberByMemberId = memberRepository.findMemberByMemberId("twkim5235")

        if (findMemberByMemberId != null) {
            println(findMemberByMemberId.name)
        }
    }
}