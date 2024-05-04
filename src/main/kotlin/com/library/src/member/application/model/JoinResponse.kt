package com.library.src.member.application.model

import com.library.src.member.domain.Grade

data class JoinResponse(
    val memberId: String,
    val name: String,
    val studentId: String,
    val grade: Grade
)