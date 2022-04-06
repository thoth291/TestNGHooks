package testingListeners.logging

class Logger {
    companion object {
        fun log(message: String) {
            println("\t\tLOGGER: $message")
        }
    }
}