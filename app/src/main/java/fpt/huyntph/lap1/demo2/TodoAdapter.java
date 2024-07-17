package fpt.huyntph.lap1.demo2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import fpt.huyntph.lap1.R;

import java.util.List;

public class TodoAdapter extends
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todoList;


    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
        void onEditClick(int position);
        void onStatusChange(int position, boolean isDone);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private Context context;
    private TodoDAO todoDAO;

    public TodoAdapter(Context context , List<Todo> todoList, TodoDAO todoDAO) {
        this.context = context;
        this.todoList = todoList;
        this.todoDAO = todoDAO;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.draft21_item_todo,
                        parent, false);
        return new TodoViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(
            @NonNull TodoViewHolder holder,
            @SuppressLint("RecyclerView") int position) {
        Todo currentTodo = todoList.get(position);
        holder.tvToDoName.setText(currentTodo.getTitle());
        holder.checkBox.setChecked(currentTodo.getStatus() == 1);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (listener != null) {
                    listener.onStatusChange(position, isChecked);
                }
            }
        });
        holder.btnDelete.setOnClickListener(v -> {
            showdeleteConfirmDialog(holder.getAdapterPosition());
        });

    }
    private void showdeleteConfirmDialog(int position){
        new AlertDialog.Builder(context)
                .setTitle("Xac nhan xoa")
                .setMessage("Ban co muon xoa khong?")
                .setPositiveButton("OK" ,(dialog, which) -> deleteTodoItem(position))
                .setNegativeButton("Cancel" , null)
                .show();

    }
    private void deleteTodoItem(int position){
        Todo todo = todoList.get(position);
        todoDAO.deleteTodo(todo.getId());
        todoList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,todoList.size());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView tvToDoName;
        public Button btnEdit, btnDelete;
        public CheckBox checkBox;

        public TodoViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvToDoName = itemView.findViewById(R.id.tvToDoName);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            checkBox = itemView.findViewById(R.id.checkBox);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
//                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                        }
                    }
                }
            });

        }

    }
}
