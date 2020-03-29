package com.example.signuplogin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class profiletab extends Fragment {
    public EditText profiletab_name,profiletab_bio,profiletab_profession,profiletab_hobbies,profiletab_favoSport;
    public Button btn_updateProfile;


    public profiletab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profiletab, container, false);
        profiletab_name=view.findViewById(R.id.profileTab_name);
        profiletab_bio=view.findViewById(R.id.profileTab_bio);
        profiletab_profession=view.findViewById(R.id.profileTab_profession);
        profiletab_hobbies=view.findViewById(R.id.profileTab_hobby);
        profiletab_favoSport=view.findViewById(R.id.profileTab_favsport);
        btn_updateProfile=view.findViewById(R.id.profileTab_updateprofile);
        final ParseUser parseUser=ParseUser.getCurrentUser();
        profiletab_name.setText(parseUser.get("ProfileName")+"");
        profiletab_bio.setText(parseUser.get("Bio")+"");
        profiletab_profession.setText(parseUser.get("Profession")+"");
        profiletab_favoSport.setText(parseUser.get("FavouriteSport")+"");
        profiletab_hobbies.setText(parseUser.get("Hobbies")+"");
        if (parseUser.get("ProfileName")==null ||parseUser.get("Bio")==null||parseUser.get("Profession")==null||
                parseUser.get("FavouriteSport")==null||parseUser.get("Hobbies")==null ){
            profiletab_name.setText("");
            profiletab_bio.setText("");
            profiletab_profession.setText("");
            profiletab_favoSport.setText("");
            profiletab_hobbies.setText("");
        }



        btn_updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("ProfileName",profiletab_name.getText().toString());
                parseUser.put("Bio",profiletab_bio.getText().toString());
                parseUser.put("Profession",profiletab_profession.getText().toString());
                parseUser.put("Hobbies",profiletab_hobbies.getText().toString());
                parseUser.put("FavouriteSport",profiletab_favoSport.getText().toString());
                Toast.makeText(getContext(),parseUser.getUsername()+profiletab_name.getText().toString(),Toast.LENGTH_LONG).show();




                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(getContext(),"Profile Updated "+profiletab_name.getText().toString(),Toast.LENGTH_LONG).show();

                        }else
                            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();



                    }
                });

            }
        });
        return view;
    }

}
