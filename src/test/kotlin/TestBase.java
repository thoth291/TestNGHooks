import org.testng.annotations.Listeners;

@Listeners({
        testingListeners.logging.Listener4Logger.class,
        testingListeners.logging.Listener4qaseio.class
})
abstract public class TestBase {
}
