package com.example.moodbyte.components

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalTimeAdapter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_TIME

    @ToJson
    fun toJson(time: LocalTime): String {
        return time.format(formatter)
    }

    @FromJson
    fun fromJson(time: String): LocalTime {
        return LocalTime.parse(time, formatter)
    }
}