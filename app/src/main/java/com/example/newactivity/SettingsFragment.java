package com.example.newactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment {

  //  private OnFragmentInteractionListener mListener;
  SharedPreferences preferences;
  SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        RadioGroup radGrp = (RadioGroup)view.findViewById(R.id.radios);
        RadioButton radioButton;
        preferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        editor = preferences.edit();
        switch(preferences.getString("research", "Google")){
            case "Google":
                radioButton = (RadioButton)view.findViewById(R.id.google);
                radioButton.setChecked(true);
                break;
            case "Яндекс":
                radioButton = (RadioButton)view.findViewById(R.id.yandex);
                radioButton.setChecked(true);
                break;
            case "Bing":
                radioButton = (RadioButton)view.findViewById(R.id.bing);
                radioButton.setChecked(true);
                break;
        }
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch(id) {
                    case R.id.google:
                        editor.putString("research", getResources().getString(R.string.google)).commit();
                        break;
                    case R.id.yandex:
                        editor.putString("research", getResources().getString(R.string.yandex)).commit();
                        break;
                    case R.id.bing:
                        editor.putString("research", getResources().getString(R.string.bing)).commit();
                        break;
                }
            }});
        return view;
    }
}
