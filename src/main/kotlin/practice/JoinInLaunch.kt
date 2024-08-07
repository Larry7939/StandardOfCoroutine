package practice

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    var x = "before"
    launch {
        disconnect(x)
    }.join()
    x = "after"
    connect(x)
}

suspend fun disconnect(x:String) {
    coroutineScope {
        launch {
            delay(3000L)
            println("disconnect x -> $x")
        }.join()
        launch {
            delay(2000L)
            println("zzz")
        }
    }
}

suspend fun connect(x: String) {
    coroutineScope {
        launch {
            delay(1000L)
            println("connect x -> $x")
        }
    }
}
