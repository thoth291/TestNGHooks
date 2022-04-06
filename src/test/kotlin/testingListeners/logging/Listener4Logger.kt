package testingListeners.logging

import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.TestListenerAdapter

class Listener4Logger : TestListenerAdapter() {
    override fun onStart(context: ITestContext) {
        Logger.log("Beginning test suite: ${context.outputDirectory}")
    }
    override fun onFinish(context: ITestContext?) {}
    override fun onTestSkipped(result: ITestResult?) {}
    override fun onTestStart(result: ITestResult) {
        super.onTestStart(result)
        Logger.log("START RESULT: $result")
        Logger.log("===>>> Test started: ${result.name}")
    }
    override fun onTestSuccess(result: ITestResult?) {
        super.onTestSuccess(result)
        if (result != null) {
            Logger.log("onSuccess: $result")
            Logger.log("<<<=== Test completed successfully: ${result.name}")
        }else {
            Logger.log("NULL onSuccess: $result")
        }
    }
    override fun onTestFailure(result: ITestResult) {
        super.onTestFailure(result)
        Logger.log("onFail: $result")
        Logger.log("<<<=== Test failed: ${result.name}")
    }
    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {}
}