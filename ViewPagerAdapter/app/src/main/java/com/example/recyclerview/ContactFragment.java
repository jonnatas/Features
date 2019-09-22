package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    private List<Contact> contactList;
    private RecyclerView recyclerView;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Neymar", "95 666 666666", R.drawable.neymar));
        contactList.add(new Contact("Menino Ney", "95 666 666666", R.drawable.ney2));
        contactList.add(new Contact("Ronaldo", "95 666 666666", R.drawable.ronaldo));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = v.findViewById(R.id.contctRecyclerViewId);
        ContactAdapter contactAdapter = new ContactAdapter(getContext(), contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(contactAdapter);

        return v;
    }

}
