package com.example.dev_intensive_2019.extensions

import com.example.dev_intensive_2019.models.User
import com.example.dev_intensive_2019.models.UserView
import com.example.dev_intensive_2019.utils.Utils
import java.util.*

fun User.toUserView() : UserView {

     val nickName = Utils.transliteration("$firstName $lastName")
     val initials = Utils.toInitials(firstName, lastName)
     val status = if (lastName == null ) "Еще ни разу не был" else if (isOnline) "Online" else "Последний раз был ${lastVisit?.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status,

    )
}


