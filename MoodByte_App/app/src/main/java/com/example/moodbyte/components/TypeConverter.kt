package com.example.moodbyte.components

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime

class TypeConverter {
/**
* LocalTime
 **/
    @TypeConverter
    fun fromLocalTime(time: LocalTime?): String? {
        return time?.toString()
    }

    @TypeConverter
    fun toLocalTime(value: String?): LocalTime? {
        return value?.let { LocalTime.parse(it) }
    }
    /**
     * LocalDate
     **/
    @TypeConverter
    fun fromLocalDate(time: LocalDate?): String? {
        return time?.toString()
    }

    @TypeConverter
    fun toLocalDate(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }
}
