package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    private static final String TAG = FragmentTwo.class.getSimpleName();

    RecyclerView recyclerView;
    ArrayList<DataModel> dataHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: Fragment Two");
        View view = inflater.inflate(R.layout.fragment_tabtwo, container, false);
        recyclerView=view.findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        DataModel ob1 = new DataModel(R.drawable.dunkirk, "Dunkirk", "2016");
        dataHolder.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.badboysforlife, "Bad Boys for Life", "2020");
        dataHolder.add(ob2);

        DataModel ob3 = new DataModel(R.drawable.ted, "Ted", "2012");
        dataHolder.add(ob3);

        DataModel ob4 = new DataModel(R.drawable.iamnumberfour, "I am Number Four", "2011");
        dataHolder.add(ob4);

        recyclerView.setAdapter(new Adapter(dataHolder));

        return view;
    }
}
