package com.example.m7mdmimo.jerb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.domain.model.Plan;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {


    private final ArrayList<Plan> planArrayList;
    private String plan_fake_names = "QWERTYUIOPLKJHGFDSAZXCVBNM";

    public PlanAdapter(ArrayList<Plan> planArrayList) {
        super();
        this.planArrayList = planArrayList;
    }


    @Override
    public int getItemCount() {
        return planArrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plan_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Random random = new Random();
        char plan_name = plan_fake_names.charAt(random.nextInt(plan_fake_names.length()));
        holder.textView_name.setText("" + plan_name);
        holder.textView_cost.setText(Integer.toString(planArrayList.get(position).getCost()));
        holder.textView_friendsNum.setText(Integer.toString(planArrayList.get(position).getGuest_num()));
        holder.textView_location.setText(planArrayList.get(position).getLocation());
        int fake_precentage = random.nextInt(100);
        holder.donutProgress.setDonut_progress(fake_precentage + "");
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_plan_name)
        TextView textView_name;
        @BindView(R.id.tv_plan_location)
        TextView textView_location;
        @BindView(R.id.tv_friends_num)
        TextView textView_friendsNum;
        @BindView(R.id.tv_cost)
        TextView textView_cost;
        @BindView(R.id.donut_progress)
        DonutProgress donutProgress;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}