package chapter7.code12

import kotlinx.coroutines.*

fun main() {
  val coroutineScope = CoroutineScope(Dispatchers.IO)
  coroutineScope.launch {
    delay(100L) // 100밀리초 대기
    println("[${Thread.currentThread().name}] 코루틴 실행 완료")
  }
  Thread.sleep(1000L) // launch는 runBlocking과는 달리 호출된 스레드를 블로킹하지 않기때문에, 강제로 스레드를 Block하였음.
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#1] 코루틴 실행 완료
*/