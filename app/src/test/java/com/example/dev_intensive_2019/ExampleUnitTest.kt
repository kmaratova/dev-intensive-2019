package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.TimeUnits
import com.example.dev_intensive_2019.extensions.add
import com.example.dev_intensive_2019.extensions.format
import com.example.dev_intensive_2019.extensions.toUserView
import com.example.dev_intensive_2019.models.*
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2","John","Cena")
    }

    @Test
    fun test_factory() {
      // val user = User.makeUser("John Cena")
     //  val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
       val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val(id, firstName, lastName) = getUserInfo()
        print("${user.component1()}, ${user.component2()}, ${user.component3()}")
        user.component1()
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
             ${user.lastVisit?.format()}
             ${user2.lastVisit?.format()}
             ${user3 .lastVisit?.format()}
             ${user4.lastVisit?.format()}
             """.trimIndent())

    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Маратова Кымбат")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)
        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Маратова Кымбат")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text  message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image  message", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

}