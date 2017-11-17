package com.example.m7mdmimo.jerb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.domain.model.GuestTodo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {


    private final ArrayList<GuestTodo> guestTodoArrayList;

    public TodoAdapter(ArrayList<GuestTodo> guestTodoArrayList) {
        super();
        this.guestTodoArrayList = guestTodoArrayList;
    }


    @Override
    public int getItemCount() {
        return guestTodoArrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView_todo_data.setText(guestTodoArrayList.get(position).getTitle());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_todo_data)
        TextView textView_todo_data;
        @BindView(R.id.radio_todo)
        RadioButton radioButton_todo;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}