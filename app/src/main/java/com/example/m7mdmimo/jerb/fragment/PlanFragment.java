package com.example.m7mdmimo.jerb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.concrete.PlanConcrete;
import com.example.m7mdmimo.jerb.presenter.PlanPresenter;

import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;


public class PlanFragment extends Fragment implements PlanConcrete.iPlanView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int SEEKBAR_MAX = 1000;
    private static final int SEEKBAR_MIN = 100;
    private static final int SEEKBAR_INCREMENT = 50;
    private static final int MIN_GUEST = 10000, MAX_GUEST = 100000000;
    private String[] plan_cities;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Unbinder binder;
    private Context context;

    @BindView(R.id.jerb_app_bar)
    Toolbar toolbar;
    @BindView(R.id.seek_plan_friends)
    SeekBar seekBar_plan_friend;
    @BindView(R.id.tv_seek_value)
    TextView textView_seek_value;
    @BindView(R.id.autocomplete_plan_cities)
    AutoCompleteTextView autoComplete_planCities;
    @BindView(R.id.radio_plan_location_default)
    RadioButton radio_planLocation;
    @BindView(R.id.radio_plan_cost_default)
    RadioButton radio_planCost;
    @BindView(R.id.edit_plan_cost)
    EditText editText_planCost;
    @Inject
    PlanPresenter planPresenter;

    public PlanFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_plan, container, false);
        binder = ButterKnife.bind(this, inflate);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line, plan_cities);
        autoComplete_planCities.setAdapter(adapter);

        seekBar_plan_friend.setProgress(SEEKBAR_MIN);
        seekBar_plan_friend.incrementProgressBy(SEEKBAR_INCREMENT);
        seekBar_plan_friend.setMax(SEEKBAR_MAX);
        seekBar_plan_friend.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 50;
                progress = progress * 50;
                textView_seek_value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return inflate;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
        plan_cities = context.getResources().getStringArray(R.array.plan_cities);
    }

    @OnClick(R.id.btn_save)
    public void save(View v) {
        Random random = new Random();
        int cost;
        String city;
        if (!radio_planCost.isChecked()) {
            String cost_data = editText_planCost.getText().toString();
            if (cost_data.equals("")) {
                editText_planCost.setError("required");
                return;
            } else
                cost = Integer.parseInt(cost_data);

        } else
            cost = random.nextInt(MAX_GUEST - MIN_GUEST + 1) - MIN_GUEST;

        if (!radio_planLocation.isChecked()) {
            city = autoComplete_planCities.getText().toString();
            if (city.equals(""))
                autoComplete_planCities.setError("Required");
            return;

        } else
            city = plan_cities[random.nextInt(plan_cities.length)];

        String friend_familyData = textView_seek_value.getText().toString();
        int friends_family;
        if (friend_familyData.equals("")) {
            autoComplete_planCities.setError("Required");
            return;
        } else
            friends_family = Integer.parseInt(friend_familyData);

        planPresenter.savePlan(friends_family, cost, city);
        ((OnSaveClicked) context).navigateToTodoFragment();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    public interface OnSaveClicked {
        void navigateToTodoFragment();
    }
}
