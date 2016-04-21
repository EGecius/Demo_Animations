package recyclerview;

import java.util.ArrayList;
import java.util.List;

interface RecyclerActivityInterface {

	void showRecycler(ArrayList<Task> tasks);

	List<Task> getRecyclerData();
}
