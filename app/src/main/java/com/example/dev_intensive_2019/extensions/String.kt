package com.example.dev_intensive_2019.extensions

fun String.truncate(n: Int = 16): String {
    return if (n <= length) "${substring(0, n).trim()}..." else substring(0, n)

}

fun String.stripHtml(): String {
    var s = replace("\\s+".toRegex(), " ")
    s = s.replace("<[^>]*>".toRegex(), "")
    return s
}