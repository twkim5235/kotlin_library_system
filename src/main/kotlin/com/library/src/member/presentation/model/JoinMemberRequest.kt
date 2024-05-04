package com.library.src.member.presentation.model

import com.library.src.member.domain.Grade

data class JoinMemberRequest(
    val memberId: String,
    val password: String,
    val email: String,
    val name: String,
    val studentId: String,
    val grade: Grade
) {

}