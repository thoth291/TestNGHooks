package testingListeners.logging

import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.TestListenerAdapter

class Listener4stdout : TestListenerAdapter() {
    override fun onStart(context: ITestContext) {
        Logger4stdout.log("Beginning test suite: ${context.outputDirectory}")
    }
    override fun onFinish(context: ITestContext?) {}
    override fun onTestSkipped(result: ITestResult?) {}
    override fun onTestStart(result: ITestResult) {
        super.onTestStart(result)
        Logger4stdout.log("===>>> Test started: ${result.name}")
    }
    override fun onTestSuccess(result: ITestResult?) {
        super.onTestSuccess(result)
        if (result != null) {
            Logger4stdout.log("<<<=== Test completed successfully: ${result.name}")
        }
    }
    override fun onTestFailure(result: ITestResult) {
        super.onTestFailure(result)
        Logger4stdout.log("<<<=== Test failed: ${result.name}")
    }
    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {}
}