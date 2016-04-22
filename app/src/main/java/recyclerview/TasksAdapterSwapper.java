package recyclerview;

import android.support.annotation.Nullable;

import java.util.List;

/** Swaps data in {@link TasksAdapter} when items get checked/unchecked */
// TODO: 22/04/2016 generify this
final class TasksAdapterSwapper {

	interface Callback {
		/**
		 * @param sortedTasks tasks sorted - completed at the top
		 * @param from moved from this position
		 * @param to moved to this position
		 */
		void swap(final List<Task> sortedTasks, final Integer from, final Integer to);
	}


	public TasksAdapterSwapper() {
	}

	public void onCheckedChanged(List<Task> data, final Callback callback) {

		Integer lastCompleteIndex = getLastCompleteIndex(data);
		Integer firstNotCompleteIndex = getFirstNotCompleteIndex(data);

		List<Task> sortedTasks = new Sorter().sortByCompleted(data);

		if (lastCompleteIndex != null && firstNotCompleteIndex != null && lastCompleteIndex > firstNotCompleteIndex) {

			//noinspection UnusedAssignment
			data = sortedTasks;
			callback.swap(sortedTasks, lastCompleteIndex, firstNotCompleteIndex);
//			tasksAdapter.notifyItemMoved(lastCompleteIndex, firstNotCompleteIndex);
		}
	}

	@Nullable
	private Integer getLastCompleteIndex(final List<Task> data) {
		Integer lastCompleteIndex = null;

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).isComplete) {
				lastCompleteIndex = i;
			}
		}

		return lastCompleteIndex;
	}

	@Nullable
	private Integer getFirstNotCompleteIndex(final List<Task> data) {
		for (int i = 0; i < data.size(); i++) {
			boolean isComplete = data.get(i).isComplete;
			if (!isComplete) {
				return i;
			}
		}
		return null;
	}

}
