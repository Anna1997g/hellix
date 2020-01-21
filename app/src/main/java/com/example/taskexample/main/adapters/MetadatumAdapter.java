package com.example.taskexample.main.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskexample.R;
import com.example.taskexample.base.adapters.OnItemClickListener;
import com.example.taskexample.network.entities.Metadatum;
import com.example.taskexample.utils.DateUtils;
import com.example.taskexample.utils.utils_glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;

public class MetadatumAdapter extends RecyclerView.Adapter<MetadatumAdapter.MyViewHolder> {

    private List<Metadatum> metadatumList = new ArrayList<>();
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public MetadatumAdapter() {
    }

    public List<Metadatum> getMetadatumList() {
        return metadatumList;
    }

    public void setMetadatumList(List<Metadatum> metadatumList) {
        this.metadatumList = metadatumList;
        notifyDataSetChanged();
    }

    public Metadatum getItem(int position) {
        return metadatumList.get(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.metadatum_item, parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Metadatum currMetadatum = metadatumList.get(position);

        holder.tvTitle.setText(currMetadatum.getTitle());
        holder.tvCategory.setText(currMetadatum.getCategory());
        holder.tvDate.setText(DateUtils.setDate(currMetadatum.getDate().toString()));

        @ColorRes int colorResId = 0;
        if (currMetadatum.getSeen()) {
            colorResId = R.color.seenItemBackgroundColor;
        } else {
            colorResId = R.color.colorWhite;
        }
        holder.constraintLayout.setBackgroundColor(ContextCompat.getColor(holder.constraintLayout.getContext(), colorResId));

        GlideUtils.setCenterCropedImage(holder.ivImage, currMetadatum.getCoverPhotoUrl());

    }

    @Override
    public int getItemCount() {
        return metadatumList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivImage;
        private TextView tvTitle, tvCategory, tvDate;
        private ConstraintLayout constraintLayout;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_photo);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvDate = itemView.findViewById(R.id.tv_date);
            constraintLayout = itemView.findViewById(R.id.cl_root);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                listener.onItemClicked(getAdapterPosition());
            }
        }
    }
}
