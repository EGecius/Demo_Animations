package recyclerview;

import java.util.ArrayList;
import java.util.List;

interface RecyclerActivityInterface {

	void showRecycler(ArrayList<Task> tasks);

	List<Task> getRecyclerData();

	void updateListWithAnimation(final List<Task> sortedTasks, final int indexInitial, final int indexSorted);

	void updateList(Task task);
}
