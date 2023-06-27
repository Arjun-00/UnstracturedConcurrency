package com.posibolt.unstracturedconcurrency

import kotlinx.coroutines.*

class StructuredConcurrency {
    var count = 0
    lateinit var deferrred : Deferred<Int>
    suspend fun calculate() : Int{

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(2000)
                count = 50
            }

           deferrred =  async(Dispatchers.IO){
                delay(4000)
               return@async 70
            }
        }
        return count + deferrred.await()
    }

}