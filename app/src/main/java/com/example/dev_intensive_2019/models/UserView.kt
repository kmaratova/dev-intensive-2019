package com.example.dev_intensive_2019.models

import java.sql.ClientInfoStatus

  data class UserView(
    val id: String,
    val fullName: String,
    val nickName: String,
    val avatar: String? = null,
    var status: String? = "offline",
    val initials: String?
) {
    fun printMe() {
      println("""
    id: $id:
    fullName: $fullName:
    nickName: $nickName:
    avatar: $avatar:
    status: $status:
    initials: $initials:
    """.trimIndent())
    }

  }

