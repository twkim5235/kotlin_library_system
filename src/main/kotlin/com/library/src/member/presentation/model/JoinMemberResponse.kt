package com.library.src.member.presentation.model

import com.library.src.member.domain.Grade

data class JoinMemberResponse(
        val memberId: String,
        val name: String,
        val studentId: String,
        val grade: Grade,
        val message: String
) {
}