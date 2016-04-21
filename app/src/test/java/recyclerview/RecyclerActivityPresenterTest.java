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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
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

		//WHEN
		presenter.onTaskChecked( /*taskId*/ 3, true);

		//THEN
		verify(view).updateListWithAnimation(captor.capture(), eq(2), eq(0));
		List<Task> list = captor.getValue();
		assertThat(list.get(0).isComplete).isTrue();
		assertThat(list.get(1).isComplete).isFalse();
		assertThat(list.get(2).isComplete).isFalse();
	}

}