package com.example.m7mdmimo.jerb.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.adapter.PlanAdapter;
import com.example.m7mdmimo.jerb.adapter.TipsAdapter;
import com.example.m7mdmimo.jerb.adapter.TodoAdapter;
import com.example.m7mdmimo.jerb.concrete.GusetTodoConcrete;
import com.example.m7mdmimo.jerb.domain.model.GuestTodo;
import com.example.m7mdmimo.jerb.domain.model.Plan;
import com.example.m7mdmimo.jerb.domain.model.Tips;
import com.example.m7mdmimo.jerb.presenter.GusetTodoPresenter;

import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.iwgang.countdownview.CountdownView;
import dagger.android.support.AndroidSupportInjection;

public class GusetToDoFramgent extends Fragment implements GusetTodoConcrete.iGusetTodoView {
    private static final int PICK_IMAGE = 1;
    private Unbinder binder;
    @Inject
    GusetTodoPresenter gusetTodoPresenter;
    @BindView(R.id.recycler_plans)
    RecyclerView recyclerView_plan;
    @BindView(R.id.recycler_tips)
    RecyclerView recyclerView_tips;
    @BindView(R.id.recycler_todo)
    RecyclerView recycler_todo;
    @BindView(R.id.progress_loading)
    ProgressBar progressBar_loading;

    @BindView(R.id.btn_add_plan)
    FloatingActionButton button_addPlan;
    private Context context;
    @BindView(R.id.jerb_app_bar)
    Toolbar toolbar;
    @BindView(R.id.relative_counter_container)
    RelativeLayout relativeLayout;
    @BindView(R.id.btn_add_cover)
    Button button_add_cover;
    @BindView(R.id.count_plan)
    CountdownView countdownView;

    @BindView(R.id.image_cover)
    ImageView image_cover;
    private long currentTime;

    public GusetToDoFramgent() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //// TODO: 11/13/2017  change Tips Beofore Wedding text and size
        View inflate = inflater.inflate(R.layout.fragment_guset_to_do_framgent, container, false);
        binder = ButterKnife.bind(this, inflate);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ArrayList<Plan> arrayList = new ArrayList<>();
        Plan plan = new Plan(1, 2000, 50, "Hello", "cairo");
        arrayList.add(plan);
        arrayList.add(plan);
        arrayList.add(plan);
        arrayList.add(plan);
        recyclerView_tips.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_todo.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_plan.setLayoutManager(new LinearLayoutManager(getActivity()));

        gusetTodoPresenter.loadTipList(this);
        gusetTodoPresenter.loadPlans(this);

        return inflate;
    }

    @OnClick(R.id.relative_counter_container)
    public void showDateDialog() {
        currentTime = Calendar.getInstance().getTime().getTime();
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_date_dialog);
        Button button = dialog.findViewById(R.id.btn_ok);
        final DatePicker datePicker = dialog.findViewById(R.id.date_plan);
        dialog.setTitle("Choose Date");
        dialog.show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                long plan_date = calendar.getTime().getTime();

                long count_down = plan_date - currentTime;
                countdownView.start(count_down);
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.btn_add_plan)
    public void addPlan(View view) {
        ((OnAddButtonClicked) context).navigateToPlanFragment();
    }

    @OnClick(R.id.btn_add_cover)
    public void addCovet(View v) {
        ((OnAddButtonClicked) context).getImageFromGallery();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }

    public void setCover(String imagePath) {
        Glide.with(this).load(imagePath)
                .placeholder(R.drawable.cover_photo)
                .centerCrop()
                .into(image_cover);
    }

    @Override
    public void startLoading() {
        progressBar_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar_loading.setVisibility(View.GONE);
    }

    @Override
    public void showTipList(ArrayList<Tips> tipsArrayList) {
        TipsAdapter planAdapter = new TipsAdapter(tipsArrayList, Glide.with(this));
        recyclerView_tips.setAdapter(planAdapter);
    }

    @Override
    public void showToDoList(ArrayList<GuestTodo> guestTodResponse) {
        TodoAdapter todoAdapter = new TodoAdapter(guestTodResponse);
        recycler_todo.setAdapter(todoAdapter);
    }

    @Override
    public void showPlanList(ArrayList<Plan> planArrayList) {
        PlanAdapter planAdapter = new PlanAdapter(planArrayList);
        recyclerView_plan.setAdapter(planAdapter);
    }

    @Override
    public void showError(String errorMessage) {

    }

    public void getUpdatdPlanList() {
        gusetTodoPresenter.loadPlans(this);
    }

    public interface OnAddButtonClicked {
        void navigateToPlanFragment();

        void getImageFromGallery();
    }
}
