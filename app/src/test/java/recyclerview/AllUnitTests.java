package recyclerview;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all unit tests in the project
 */
@RunWith (Suite.class)
@Suite.SuiteClasses({
		RecyclerActivityPresenterTest.class,
		SorterTest.class,
		TasksAdapterSwapperTest.class
})
public class AllUnitTests {
}
