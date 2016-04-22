package recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.egecius.demo_animations.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

final public class RecyclerActivity extends AppCompatActivity implements RecyclerActivityInterface {

	RecyclerActivityPresenter presenter = new RecyclerActivityPresenter(this);

	@Bind (R.id.editText) EditText editText;
	@Bind (R.id.recycler) RecyclerView recycler;
	private TasksAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		iniUi();
		presenter.onCreate();
	}

	private void iniUi() {
		setContentView(R.layout.recycler_activity);
		ButterKnife.bind(this);
		initAdapter();
	}

	private void initAdapter() {
		Context ctx = getApplicationContext();
		adapter = new TasksAdapter(ctx);
		recycler.setLayoutManager(new LinearLayoutManager(ctx));
		recycler.setNestedScrollingEnabled(true);
		recycler.setAdapter(adapter);
	}

	@Override
	public void showRecycler(final ArrayList<Task> tasks) {
		adapter.setData(tasks);
	}

	@Override
	public List<Task> getRecyclerData() {
		return adapter.getData();
	}

	@Override
	public void updateListWithAnimation(final List<Task> sortedTasks, final int indexInitial, final int indexSorted) {
		adapter.notifyItemMoved(sortedTasks, indexInitial, indexSorted);
	}

	@Override
	public void updateList(final Task task) {
		adapter.updateTask(task);
	}

	@OnClick (R.id.updateBtn)
	void onUpdateBtnClicked() {
		String input = editText.getText().toString();
		presenter.onUpdateBtnClicked(input);
	}

}
