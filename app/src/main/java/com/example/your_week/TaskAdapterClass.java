package com.example.your_week;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapterClass extends RecyclerView.Adapter<TaskAdapterClass.ViewHolder> {

    List<TaskModel> tasks;
    Context context;
    TaskDataHelper taskDataHelper;

    public TaskAdapterClass(List<TaskModel> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
        taskDataHelper = new TaskDataHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.task_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TaskModel taskModel = tasks.get(position);

        holder.textViewID.setText(Integer.toString(taskModel.getId()));
        holder.editText_Task.setText(taskModel.getTaskName());
        holder.editText_Date.setText(taskModel.getTaskDate());
        holder.editText_Time.setText(taskModel.getTaskTime());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringTask = holder.editText_Task.getText().toString();
                String stringDate = holder.editText_Date.getText().toString();
                String stringTime = holder.editText_Time.getText().toString();

                taskDataHelper.updateTask(new TaskModel(taskModel.getId(),
                        stringTask,stringDate,stringTime));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
        holder.button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDataHelper.deleteTask(taskModel.getId());
                tasks.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    //Getterillä saadaan selville kuinka monta taskia taulussa on.
    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editText_Task;
        EditText editText_Date;
        EditText editText_Time;
        Button button_Edit;
        Button button_Delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Task = itemView.findViewById(R.id.edittext_task);
            editText_Date = itemView.findViewById(R.id.edittext_date);
            editText_Time = itemView.findViewById(R.id.edittext_time);
            button_Edit = itemView.findViewById(R.id.button_edit);
            button_Delete = itemView.findViewById(R.id.button_delete);
        }
    }

}
