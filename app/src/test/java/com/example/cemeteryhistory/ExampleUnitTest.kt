package com.example.cemeteryhistory

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

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
    fun main() : Unit = runBlocking {
        repeat(100){
            launch {
                val result = doWord("Android")
             println(result)
            }
        }
    }

    suspend fun doWord(name:String):String{
        delay(5000)
        return "Done. $name"
    }
}