import org.testng.annotations.Listeners;

@Listeners({testingListeners.logging.Listener4Logger.class, testingListeners.logging.Listener4stdout.class})
abstract public class TestBase {
}
