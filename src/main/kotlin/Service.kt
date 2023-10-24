class Service {
    fun <T> runReadAction(action: SAM<T>): T {
        val result = action.doWork()
        println(result)
        return result
    }
}