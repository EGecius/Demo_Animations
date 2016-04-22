package recyclerview;

import android.support.annotation.NonNull;

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

/**
 * Tests for {@link TasksAdapterSwapper}
 */
@RunWith (MockitoJUnitRunner.class)
public class TasksAdapterSwapperTest {


	public static final int ID_1 = 2;
	public static final int ID_2 = 3;
	public static final int ID_0 = 1;
	public static final int ID_3 = 4;


	TasksAdapterSwapper swapper;
	private ArrayList<Task> tasks = new ArrayList<>();
	private Task task3;

	@Captor ArgumentCaptor<TasksAdapterSwapper.Callback> captorCallback;
	@Captor ArgumentCaptor<List<Task>> captorTasks;

	@Mock TasksAdapterSwapper.Callback swapperCallback;

	@Before
	public void setup() {
		swapper = new TasksAdapterSwapper();

		tasks.add(new Task(ID_0, "Task zero", false));
		tasks.add(new Task(ID_1, "Task one", false));
		task3 = new Task(ID_2, "Task two", false);
		tasks.add(task3);
		tasks.add(new Task(ID_3, "Task three", false));
	}

	@Test
	public void when_then() {
		//GIVEN
		task2SetToComplete();

		//WHEN
//		TasksAdapterSwapper.Callback swapperCallback = getCallback();
		swapper.onCheckedChanged(tasks, swapperCallback);

		verify(swapperCallback).swap(captorTasks.capture(), eq(2), eq(0));
		List<Task> tasks = captorTasks.getValue();
		assertThat(tasks.get(0).id == ID_2).isTrue();
		assertThat(tasks.get(1).id == ID_0).isTrue();
		assertThat(tasks.get(2).id == ID_1).isTrue();
		assertThat(tasks.get(3).id == ID_3).isTrue();

		//THEN

	}

	@NonNull
	private TasksAdapterSwapper.Callback getCallback() {
		return new TasksAdapterSwapper.Callback() {
			@Override
			public void swap(final List<Task> sortedTasks, final Integer from, final Integer to) {

			}
		};
	}

	private void task2SetToComplete() {
		task3.isComplete = true;
	}

}