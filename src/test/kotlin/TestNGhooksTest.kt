import org.testng.Assert.assertEquals
import org.testng.annotations.Test

/**
 *  They can be added to testng.xml like this
 *
    <listeners>
    <listener class-name="org.uncommons.reportng.HTMLReporter"/>
    <listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
    </listeners>
 * */



class TestNGhooksTest : TestBase() {

    @Test
    fun happyTest() {
        val expected = 10
        val result = 5+5
        assertEquals(result, expected)
    }

    @Test
    fun `unhappy test`() {
        val expected = 0
        val result = 5-4
        assertEquals(result,expected,"The expression 5-4 is not equal to 0")
    }

}