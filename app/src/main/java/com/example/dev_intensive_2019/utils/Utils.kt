package com.example.dev_intensive_2019.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName.isNullOrEmpty()) {
            firstName = null
        }
        if (lastName.isNullOrEmpty()) {
            lastName = null
        }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val map = mapOf (
            "а" to "a", "б" to "b", "в" to "v",
            "г" to "g", "д" to "d", "е" to "e",
            "ё" to "e", "ж" to "zh", "з" to "z",
            "и" to "i", "й" to "i", "к" to "k",
            "л" to "l", "м" to "m", "н" to "n",
            "о" to "o", "п" to "p", "р" to "r",
            "с" to "s", "т" to "t", "у" to "u",
            "ф" to "f", "х" to "h", "ц" to "c",
            "ч" to "ch", "ш" to "sh", "щ" to "sh'",
            "ъ" to "", "ы" to "i", "ь" to "",
            "э" to "e", "ю" to "yu", "я" to "ya",

            "А" to "A", "Б" to "B", "В" to "V",
            "Г" to "G", "Д" to "D", "Е" to "E",
            "Ё" to "E", "Ж" to "Zh", "З" to "Z",
            "И" to "I", "Й" to "I", "К" to "K",
            "Л" to "L", "М" to "M", "Н" to "N",
            "О" to "O", "П" to "P", "Р" to "R",
            "С" to "S", "Т" to "T", "У" to "U",
            "Ф" to "F", "Х" to "H", "Ц" to "C",
            "Ч" to "Ch", "Ш" to "Sh", "Щ" to "Sh'", "Ы" to "I",
            "Э" to "E", "Ю" to "Yu", "Я" to "Ya"
        )

        var result: String = payload
        result.forEach {
            if (map.containsKey(it.toString())) {
                result = result.replace(
                    it.toString(),
                    map.getValue(it.toString())
                )
            }
        }
        return result.split(" ").joinToString(separator = divider)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = firstName?.trimIndent()?.firstOrNull()?.uppercase()
        val last = lastName?.trimIndent()?.firstOrNull()?.uppercase()
        return when {
            first == null -> last
            last == null -> first
            else -> "$first$last"
        }
    }

}