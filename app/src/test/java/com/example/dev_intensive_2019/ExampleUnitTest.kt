package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.*
import com.example.dev_intensive_2019.models.*
import com.example.dev_intensive_2019.utils.Utils
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
        val user2 = User("2", "John", "Cena")
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
        val (id, firstName, lastName) = getUserInfo()
        print("${user.component1()}, ${user.component2()}, ${user.component3()}")
        user.component1()
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println(
            """
             ${user.lastVisit?.format()}
             ${user2.lastVisit?.format()}
             ${user3.lastVisit?.format()}
             ${user4.lastVisit?.format()}
             """.trimIndent()
        )

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
    fun test_abstract_factory() {
        val user = User.makeUser("Маратова Кымбат")
        val txtMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "any text  message", type = "text")
        val imgMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "any image  message", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_humanizeDiff() {
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год


    }

    @Test
    fun test_parseFullName() {
        println(Utils.parseFullName(null)) //null null
        println(Utils.parseFullName("")) //null null
        println(Utils.parseFullName("")) //null null
        println(Utils.parseFullName("John")) //John null
    }

    @Test
    fun test_dateFormat() {
        println(Date().format()) //14:00:00 27.06.19
        println(Date().format("HH:mm"))//14:00
    }

    @Test
    fun test_toInitials() {
        println(Utils.toInitials("john", "doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
    }

    @Test
    fun test_transliterations() {
        println(Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр", "_")) //Amazing_Petr
    }

    @Test
    fun test_Builder() {
        println(
            User.Builder().id("s")
                .firstName("s")
                .lastName("s")
                .avatar("s")
                .rating(2)
                .respect(1)
                .lastVisit(Date().add(-1))
                .isOnline(true).build()
        )

    }

    @Test
    fun test_truncate(){
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate()) //Bender Bending R...
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15)) //Bender Bending...
        println("A     ".truncate(3)) //A
    }

    @Test
    fun test_stripHtml(){
        println("<p>Образовательное IT-сообщество Skill Branch</p>".stripHtml()) //Образовательное IT-сообщество Skill Branch
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml()) //Образовательное IT-сообщество Skill Branch
    }

    @Test
    fun test_plural() {
        println(TimeUnits.SECOND.plural(1)) //1 секунду
        println(TimeUnits.MINUTE.plural(4)) //4 минуты
        println(TimeUnits.HOUR.plural(19)) //19 часов
        println(TimeUnits.DAY.plural(222)) //222 дня
    }
}