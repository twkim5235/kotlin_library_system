package com.library.src.member.application.model

import com.library.src.member.domain.Grade


class JoinCommand(
    val memberId: String,
    val password: String,
    val email: String,
    val name: String,
    val studentId: String,
    val grade: Grade
)