package com.example.newactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ResearchFragment extends Fragment implements View.OnClickListener{

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_research, container, false);
        EditText editText = (EditText) getActivity().findViewById(R.id.editText);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        EditText editText = (EditText) getActivity().findViewById(R.id.editText);
        Uri uri=Uri.parse("");
        switch(preferences.getString("research", "Google")){
            case "Google":
                uri = Uri.parse("https://www.google.com/search?q="+editText.getText().toString());
                break;
            case "Bing":
                uri = Uri.parse("https://www.bing.com/search?q="+editText.getText().toString());
                break;
            case "Яндекс":
                uri = Uri.parse("https://yandex.ru/search/?text="+editText.getText().toString());
                break;
        }
//        Uri uri = Uri.parse("https://www."+preferences.getString("research", "google")+".com/search?q="+editText.getText().toString());
        Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(gSearchIntent);
    }
}