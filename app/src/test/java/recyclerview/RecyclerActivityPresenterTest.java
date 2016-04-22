package recyclerview;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Tests for {@link RecyclerActivityPresenter}
 */
@RunWith (MockitoJUnitRunner.class)
public class RecyclerActivityPresenterTest {

	RecyclerActivityPresenter presenter;

	@Mock RecyclerActivityInterface view;
	@Captor ArgumentCaptor<List<Task>> captor;

	@Before
	public void setup() {
		presenter = new RecyclerActivityPresenter(view);
		when(view.getRecyclerData()).thenReturn(getInitialList());
	}

	private List<Task> getInitialList() {

		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, "Task one", false));
		tasks.add(new Task(2, "Task two", false));
		tasks.add(new Task( /*taskId*/ 3, "Task three", false));

		return tasks;
	}

	@Test
	public void when__then() {
	}

}