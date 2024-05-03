package com.library.src.member.domain

import com.library.src.member.infra.GradeConverter
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.Builder
import lombok.Getter
import lombok.Setter

@Entity
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
class Member(
    id: Long?,
    memberId: String,
    password: String,
    email: String,
    name: String,
    studentId: String,
    grade: Grade
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 15)
    var memberId: String

    @Column
    var password: String

    @Column(length = 30)
    var email: String

    @Column(length = 5)
    var name: String

    @Column(length = 8)
    var studentId: String

    @Column(columnDefinition = "Int")
    @Convert(converter = GradeConverter::class)
    var grade: Grade

    init {
        this.id = id
        this.memberId = memberId
        this.password = password
        this.email = email
        this.name = name
        this.studentId = studentId
        this.grade = grade
    }

    constructor(
        memberId: String,
        password: String,
        email: String,
        name: String,
        studentId: String,
        grade: Grade
    ) : this(null, memberId, password, email, name, studentId, grade)

}