package com.example.dev_intensive_2019.utils

import android.service.voice.AlwaysOnHotwordDetector

object Utils {
    fun parseFullName (fullName:String?):Pair<String?, String?>{

        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return ""
    }


}