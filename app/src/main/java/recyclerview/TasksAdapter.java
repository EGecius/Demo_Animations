package recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.egecius.demo_animations.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {


	@NonNull private final Context ctx;
	private final TasksAdapterSwapper adapterSwapper;
	private List<Task> data = new ArrayList<>();

	/**
	 * @param ctx application context
	 */
	public TasksAdapter(@NonNull final Context ctx) {
		this.ctx = ctx;
		adapterSwapper = new TasksAdapterSwapper();
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		View view = LayoutInflater.from(ctx).inflate(R.layout.tasks_list_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {
		final Task task = data.get(position);

		setCheckBoxListener(holder, task);
		holder.checkbox.setChecked(task.isComplete);
		holder.title.setText(task.title);
	}

	private void setCheckBoxListener(final ViewHolder holder, final Task d) {
		holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
				d.isComplete = isChecked;
				adapterSwapper.onCheckedChanged(data, new TasksAdapterSwapper.Callback() {
					@Override
					public void swap(final List<Task> sortedTasks, final Integer from, final Integer to) {
						data = sortedTasks;
						notifyItemMoved(from, to);
					}
				});
			}
		});
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	/**
	 * Sets data to display by this adapter
	 * @param data data to show in list
	 */
	public void setData(@Nullable List<Task> data) {
		setDataInternal(data);
		notifyDataSetChanged();
	}

	private void setDataInternal(final @Nullable List<Task> data) {
		if (data == null) {
			this.data.clear();
		} else {
			this.data = data;
		}
	}

	public List<Task> getData() {
		return data;
	}

	public void notifyItemMoved(final List<Task> sortedTasks, final int indexInitial, final int indexSorted) {
		setDataInternal(sortedTasks);
		notifyItemMoved(indexInitial, indexSorted);
	}

	public void updateTask(final Task task) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).id == task.id) {
				data.set(i, task);
				notifyItemChanged(i);
				return;
			}
		}
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		@Bind (R.id.checkbox) CheckBox checkbox;
		@Bind (R.id.title) TextView title;

		public ViewHolder(final View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
