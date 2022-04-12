package testingListeners.logging

import clients.QaseioClient
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.TestListenerAdapter

class Listener4Qaseio : TestListenerAdapter() {

    private val client = QaseioClient()

    override fun onStart(context: ITestContext) {
        val setupClient = client.setupClient()
        Logger4Qaseio.log("RESPONCE: $setupClient")
        super.onStart(context)
        Logger4Qaseio.log("BEGIN: $context")
        Logger4Qaseio.log("Beginning test suite: ${context.outputDirectory}")
    }
    override fun onFinish(context: ITestContext?) {}
    override fun onTestSkipped(result: ITestResult?) {}
    override fun onTestStart(result: ITestResult) {
        super.onTestStart(result)
        Logger4Qaseio.log("START: ${result.parameters.asSequence().map{it.toString()}.toList()}")
        Logger4Qaseio.log("CONTINUE: ${result.attributeNames}")
        Logger4Qaseio.log("===>>> Test started: ${result.name}")
    }
    override fun onTestSuccess(result: ITestResult?) {
        super.onTestSuccess(result)
        if (result != null) {
            Logger4Qaseio.log("<<<=== Test completed successfully: ${result.name}")
        }
    }
    override fun onTestFailure(result: ITestResult) {
        super.onTestFailure(result)
        Logger4Qaseio.log("<<<=== Test failed: ${result.name}")
    }
    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {}
}