package com.example.signuplogin;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserTab extends Fragment {
    private ListView usertab_listview;
    private ArrayList arrayList;
    private ArrayAdapter arrayAdapter;


    public UserTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ProgressDialog progressDialog =new ProgressDialog(getContext());
        progressDialog.setMessage("loading " );
        progressDialog.show();

        View view= inflater.inflate(R.layout.fragment_user_tab, container, false);
        usertab_listview=view.findViewById(R.id.usertab_listview);
        arrayList=new ArrayList();
        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        ParseQuery<ParseUser> parseQuery=ParseUser.getQuery();
        parseQuery.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
                if (e==null){
                    if (users.size()>0){
                        for (ParseUser user:users){
                            arrayList.add(user.getUsername());

                        }
                        usertab_listview.setAdapter(arrayAdapter);
                        progressDialog.dismiss();
                    }
                }

            }
        });
        return view;
    }

}
