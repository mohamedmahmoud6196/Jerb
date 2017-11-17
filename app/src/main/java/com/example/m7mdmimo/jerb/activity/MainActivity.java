package com.example.m7mdmimo.jerb.activity;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.m7mdmimo.jerb.R;
import com.example.m7mdmimo.jerb.adapter.PagerAdapter;
import com.example.m7mdmimo.jerb.fragment.GusetToDoFramgent;
import com.example.m7mdmimo.jerb.fragment.PlanFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, GusetToDoFramgent.OnAddButtonClicked, PlanFragment.OnSaveClicked {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri contentURI = data.getData();
            String imagePath = "";
         try {
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(contentURI, filePathColumn, null, null, null);
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imagePath = cursor.getString(columnIndex);
                }
                cursor.close();
                GusetToDoFramgent fragment = (GusetToDoFramgent) pagerAdapter.instantiateItem(viewPager, 0);
                if (fragment != null) {
                    fragment.setCover(imagePath);
                }
            } catch (Exception e) {
                    Toasty.error(MainActivity.this, "Open Permmision and choose Photo", Toast.LENGTH_LONG).show();
            }

        }
    }

    private static final int PICK_IMAGE = 1;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @BindView(R.id.pager)
    ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    GusetToDoFramgent fragment = (GusetToDoFramgent) pagerAdapter.instantiateItem(viewPager, position);
                    if (fragment != null) {
                        fragment.getUpdatdPlanList();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void navigateToPlanFragment() {
        viewPager.setCurrentItem(1);
    }

    @Override
    public void navigateToTodoFragment() {
        viewPager.setCurrentItem(0);
    }


    @Override
    public void getImageFromGallery() {
        Intent intent;
        intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}
