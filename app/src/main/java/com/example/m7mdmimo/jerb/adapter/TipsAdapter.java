package com.example.m7mdmimo.jerb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.domain.JerbUtil;
import com.example.m7mdmimo.jerb.domain.model.Tips;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m7md mimo on 11/12/2017.
 */

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {


    private final ArrayList<Tips> planArrayList;
    private final RequestManager glide;

    public TipsAdapter(ArrayList<Tips> planArrayList, RequestManager glide) {
        super();
        this.planArrayList = planArrayList;
        this.glide = glide;
    }


    @Override
    public int getItemCount() {
        return planArrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView_tip_id.setText(planArrayList.get(position).getId() + "");
        holder.textView_tip_info.setText(planArrayList.get(position).getTitle());
        String imagePath = planArrayList.get(position).getImagePath();
        glide.load(JerbUtil.Base_IMAGE_URL + imagePath)
                .placeholder(R.drawable.ic_guest_book)
                .centerCrop()
                .into(holder.imageView_tip);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_tip_info)
        TextView textView_tip_info;
        @BindView(R.id.tv_tip_id)
        TextView textView_tip_id;

        @BindView(R.id.image_tip)
        ImageView imageView_tip;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}