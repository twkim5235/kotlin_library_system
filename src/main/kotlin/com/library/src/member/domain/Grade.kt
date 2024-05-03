package com.library.src.member.domain

enum class Grade(val value: Int) {

    FRESHMAN(10),
    SOPHOMORE(20),
    JUNIOR(30),
    SENIOR(40);

    companion object {
        fun ofValue(value: Int): Grade {
            return entries.first { v -> v.value == value }
        }
    }
}