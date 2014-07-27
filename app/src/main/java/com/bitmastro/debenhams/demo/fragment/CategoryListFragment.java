package com.bitmastro.debenhams.demo.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.adapter.CategoryAdapter;
import com.bitmastro.debenhams.demo.model.CategoryModel;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.ui.layout.GridLayoutManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
@EFragment(R.layout.fragment_main)
public class CategoryListFragment extends Fragment {

    @ViewById(R.id.recycler_view)
    RecyclerView recyclerView;

    private GridLayoutManager layoutManager;

    @AfterViews
    void init() {
        // improve performance if you know that changes in content
//        // do not change the size of the RecyclerView
//        recyclerView.setHasFixedSize(true);


        final ArrayList<CategoryModel> data = new ArrayList<CategoryModel>();
        data.add(new CategoryModel("Woman", "Day Dresses", R.drawable.dresses, ProductColumns.CONTENT_URI));
        for (int i = 0; i < 10; i++) {
            data.add(new CategoryModel("Unknown", String.valueOf(i + 1), R.drawable.placeholder, null));
        }

        CategoryAdapter mAdapter = new CategoryAdapter(data);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
