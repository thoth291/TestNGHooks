import org.testng.Assert.assertEquals
import org.testng.annotations.Parameters
import org.testng.annotations.Test
import org.testng.xml.dom.Tag

/**
 *  They can be added to testng.xml like this
 *
    <listeners>
    <listener class-name="org.uncommons.reportng.HTMLReporter"/>
    <listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
    </listeners>
 * */



class TestNGhooksTest : TestBase() {

    @Tag(name = "happy")
    @Parameters(value = arrayOf("tH,tT"))
    @Test(description = "Happy Test", parameters = arrayOf("pH","pT"), groups = arrayOf("gH","gT"))
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