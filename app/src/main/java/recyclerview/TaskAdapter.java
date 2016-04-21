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

final class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {


	@NonNull private final Context ctx;
	private Listener listener;
	private List<Task> data = new ArrayList<>();

	public interface Listener {
		void onChecked(int taskId, boolean isChecked);
	}

	/**
	 * @param ctx application context
	 * @param listener listener for checking items
	 */
	public TasksAdapter(@NonNull final Context ctx, final Listener listener) {
		this.ctx = ctx;
		this.listener = listener;
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		View view = LayoutInflater.from(ctx).inflate(R.layout.tasks_list_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {
		final Task d = data.get(position);

		setCheckBoxListener(holder, d);

		holder.checkbox.setChecked(d.isComplete);
		holder.title.setText(d.title);
	}

	private void setCheckBoxListener(final ViewHolder holder, final Task d) {
		holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
				boolean hasChanged = d.isComplete != isChecked;
				if (hasChanged)
					listener.onChecked(d.id, isChecked);
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
		if (data == null) {
			this.data.clear();
		} else {
			this.data = data;
		}
		notifyDataSetChanged();
	}

	public List<Task> getData() {
		return data;
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
