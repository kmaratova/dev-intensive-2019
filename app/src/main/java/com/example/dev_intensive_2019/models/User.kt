package com.example.dev_intensive_2019.models

import com.example.dev_intensive_2019.utils.Utils
import java.util.*

data class User(
    val id: String?,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var raiting: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {
    constructor (id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's Alive!!!\n" +
                    "${
                        if (lastName === "Doe") "His name id $firstName $lastName"
                        else "And his name $firstName $lastName!!!"
                    }\n"
        )
    }

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

    data class Builder(
                       private var id: String? = null,
                       private var firstName: String? = null,
                       private var lastName: String? = null,
                       private var avatar: String? = null,
                       private var rating: Int = 0,
                       private var respect: Int = 0,
                       private var lastVisit: Date? = Date(),
                       private var isOnline: Boolean = false
    ) {
        fun id(id: String) = apply { this.id = id }
        fun firstName(id: String?) = apply { this.firstName = id }
        fun lastName(id: String?) = apply { this.lastName = id }
        fun avatar(id: String?) = apply { this.avatar = id }
        fun rating(id: Int) = apply { this.rating = id }
        fun respect(id: Int) = apply { this.respect = id }
        fun lastVisit(id: Date) = apply { this.lastVisit = id }
        fun isOnline(id: Boolean) = apply { this.isOnline = id }

        fun build() = User(
            id,
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }
}



