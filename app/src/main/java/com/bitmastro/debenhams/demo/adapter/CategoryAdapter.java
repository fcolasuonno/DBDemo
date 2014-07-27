package com.bitmastro.debenhams.demo.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.activity.ProductListActivity_;
import com.bitmastro.debenhams.demo.model.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<CategoryModel> dataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CategoryAdapter(List<CategoryModel> pDataset) {
        dataset = pDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category, parent, false);

        return new CategoryViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final CategoryModel model = dataset.get(position);
        holder.categoryTextView.setText(model.getCategory());
        holder.contentURI = model.getContentUri();
        Picasso.with(holder.itemView.getContext()).load(model.getDrawable()).into(holder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    // Provide a reference to the type of views that you are using
    // (custom viewholder)
    public static class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView categoryTextView;
        public ImageView imageView;
        public Uri contentURI;

        public CategoryViewHolder(View v) {
            super(v);
            categoryTextView = (TextView) v.findViewById(R.id.categoryTextView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ProductListActivity_.intent(v.getContext()).start();
        }
    }
}