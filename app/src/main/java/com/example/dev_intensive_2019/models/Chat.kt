package com.example.dev_intensive_2019.models

import android.provider.Telephony

class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}