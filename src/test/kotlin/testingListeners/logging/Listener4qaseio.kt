package testingListeners.logging

import clients.QaseioClient
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.TestListenerAdapter

class Listener4qaseio : TestListenerAdapter() {

    private val client = QaseioClient()

    override fun onStart(context: ITestContext) {
        client.setupClient()
        super.onStart(context)
        Logger4qaseio.log("BEGIN: $context")
        Logger4qaseio.log("Beginning test suite: ${context.outputDirectory}")
    }
    override fun onFinish(context: ITestContext?) {}
    override fun onTestSkipped(result: ITestResult?) {}
    override fun onTestStart(result: ITestResult) {
        super.onTestStart(result)
        Logger4qaseio.log("START: ${result.parameters.asSequence().map{it.toString()}.toList()}")
        Logger4qaseio.log("CONTINUE: ${result.attributeNames}")
        Logger4qaseio.log("===>>> Test started: ${result.name}")
    }
    override fun onTestSuccess(result: ITestResult?) {
        super.onTestSuccess(result)
        if (result != null) {
            Logger4qaseio.log("<<<=== Test completed successfully: ${result.name}")
        }
    }
    override fun onTestFailure(result: ITestResult) {
        super.onTestFailure(result)
        Logger4qaseio.log("<<<=== Test failed: ${result.name}")
    }
    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {}
}