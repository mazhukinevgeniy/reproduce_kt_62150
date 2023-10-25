import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CalledUtilKtTest {

    private fun moduleLocalWork() = "kt-62150"

    @Test
    fun `should discover local paths given a server path`() {
        val result = runJavaReadAction { moduleLocalWork() }
        assertEquals(result.toString(), "kt-62150")
    }
}