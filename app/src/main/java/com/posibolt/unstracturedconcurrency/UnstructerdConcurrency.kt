package com.posibolt.unstracturedconcurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UnstructerdConcurrency {

    suspend fun calculation():Int {
       var count = 0
        CoroutineScope(IO).launch {
            delay(2000)
            count = 50
        }

       val defferd = CoroutineScope(IO).async {
            delay(3000)
            return@async 70
        }
        return count + defferd.await()
    }

}