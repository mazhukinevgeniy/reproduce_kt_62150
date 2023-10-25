
class CalledUtil {
    //trick kotlin compiler into creating additional .class files
}


inline fun <T> runReadAction(crossinline runnable: () -> T): T {
    return Singleton.getService().runReadAction(SAM { runnable() })
}

inline fun <T> runJavaReadAction(crossinline runnable: () -> T): T {
    return JSingleton.getService().runReadAction(JSAM { runnable() })
}

/**
 * Let's count the nuances
 *
 * 1. inline
 *     does inlining matter?
 * 2. fun <T> runReadAction
 *     does generic matter?
 * 3.(crossinline runnable: () -> T): T {
 *     does crossinlining matter?
 * 4. return Singleton.getService()
 *     does lookup chain matter? bonus: we can make it go between modules
 * 5. .runReadAction(SAM { runnable() })
 *     does creating a local class matter?
 * }
 * 6. in reality, Computable is java interface. does it matter?
 * 7. SAM is generic, does it matter?
 * 8. in reality, runReadAction is @RequiresBlockingContext, does it matter?
 */