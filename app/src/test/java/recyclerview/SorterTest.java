package recyclerview;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Sorter}
 */
public class SorterTest {

	Sorter sorter;
	private ArrayList<Task> tasksOnlyLastComplete;

	@Before
	public void setup() {
		sorter = new Sorter();


		tasksOnlyLastComplete = new ArrayList<>();
		tasksOnlyLastComplete.add(new Task(1, "Task one", false));
		tasksOnlyLastComplete.add(new Task(2, "Task three", true));
		tasksOnlyLastComplete.add(new Task(3, "Task two", false));
		tasksOnlyLastComplete.add(new Task(4, "Task three", true));
		tasksOnlyLastComplete.add(new Task(5, "Task two", false));
	}

	@Test
	public void when__then() {
		//WHEN
		List<Task> sorted = sorter.sortByCompleted(tasksOnlyLastComplete);
		//THEN

		assertThat(sorted.size()).isEqualTo(5);
		assertThat(sorted.get(0).isComplete).isTrue();
		assertThat(sorted.get(1).isComplete).isTrue();
		assertThat(sorted.get(2).isComplete).isFalse();
		assertThat(sorted.get(3).isComplete).isFalse();
		assertThat(sorted.get(4).isComplete).isFalse();
	}

}