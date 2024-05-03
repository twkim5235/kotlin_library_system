package com.library.src.member.infra

import com.library.src.member.domain.Grade
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class GradeConverter : AttributeConverter<Grade, Int>{
    override fun convertToDatabaseColumn(grade: Grade): Int? {
        return grade.value
    }

    override fun convertToEntityAttribute(dbData: Int): Grade {
        return Grade.ofValue(dbData)
    }
}