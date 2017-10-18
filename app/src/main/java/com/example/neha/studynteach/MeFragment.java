package com.example.neha.studynteach;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{
    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }
    private RecyclerView recyclerView;
    private List<PickItem> cartList;
    private ItemAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_me, container, false);
        Toolbar toolbar =(Toolbar) v.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle(getString(R.string.app_name));
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        coordinatorLayout = (CoordinatorLayout) v.findViewById(R.id.coordinator_layout);
        cartList = new ArrayList<>();
        mAdapter = new ItemAdapter(getActivity(), cartList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        // adding item touch helper
        // only ItemTouchHelper.LEFT added to detect Right to Left swipe
        // if you want both Right -> Left and Left -> Right
        // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        prepareList();
        return v;
    }

    private void prepareList() {
        int[] covers = new int[]{
                R.drawable.ar,
                R.drawable.ai,
                R.drawable.java,
                R.drawable.health,
                R.drawable.tech,
                R.drawable.machine,
                R.drawable.magnet,
                R.drawable.python,
                R.drawable.space,
                R.drawable.c,
        };

       PickItem a = new PickItem("AR","hello ar",3, covers[0]);
        cartList.add(a);


         a = new PickItem("AI", "hello ai",3, covers[1]);
        cartList.add(a);

        a = new PickItem("JAVA", "hello java",3, covers[2]);
        cartList.add(a);

        a = new PickItem("HEALTH", "hello health",3, covers[3]);
        cartList.add(a);

        a = new PickItem("TECH", "hello tech",3, covers[4]);
        cartList.add(a);
        a = new PickItem("MACHINE", "hello machine",3, covers[5]);
        cartList.add(a);
        a = new PickItem("MAGNETISM", "hello magnetism",3, covers[6]);
        cartList.add(a);

        a = new PickItem("PYTHON", "hello python",3, covers[7]);
        cartList.add(a);

        a = new PickItem("SPACE", "hello space",3, covers[8]);
        cartList.add(a);

        a = new PickItem("C", "hello c",3, covers[9]);
        cartList.add(a);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof ItemAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getName();


            final PickItem deletedItem = cartList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " Added to bookmarks!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
    
}