package testingListeners.logging

class Logger4stdout {
    companion object {
        fun log(message: String) {
            println("\t\tSTDOUT: $message")
        }
    }
}