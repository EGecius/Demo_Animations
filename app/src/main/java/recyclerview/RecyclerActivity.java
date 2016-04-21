package recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.egecius.demo_animations.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

final public class RecyclerActivity extends AppCompatActivity implements RecyclerActivityInterface {

	RecyclerActivityPresenter presenter = new RecyclerActivityPresenter(this);

	@Bind (R.id.recycler) RecyclerView recycler;
	private TasksAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recycler_activity);
		initAdapter();
		presenter.onCreate();
	}

	@OnClick (R.id.swapItemsBtn)
	void onSwapItemsBtnClicked() {
		presenter.onSwapItemsBtnClicked();
	}

	private void initAdapter() {
		Context ctx = getApplicationContext();
		adapter = new TasksAdapter(ctx, new TasksAdapter.Listener() {
			@Override
			public void onChecked(final int taskId, final boolean isChecked) {
				presenter.onTaskChecked(taskId, isChecked);
			}
		});
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

}
