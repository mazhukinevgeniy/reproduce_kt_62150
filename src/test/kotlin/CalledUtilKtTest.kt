import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalledUtilKtTest {

    private fun moduleLocalWork() = "kt-62150"

    @Test
    fun runReadAction() {
       //// val result = moduleLocalWork()
        val result = runReadAction { moduleLocalWork() }
        assertEquals(result.toString(), "kt-62150")
    }
}