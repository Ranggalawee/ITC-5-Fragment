package com.example.tugasfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String statKd, statYfk;
    int activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statKd = " 2500          700        10000";
        statYfk = " 2300          500        15000";

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentSatu mFragmentSatu = new FragmentSatu();
        Fragment fragmentSatu = mFragmentManager.findFragmentByTag(FragmentSatu.class.getSimpleName());

        if (!(fragmentSatu instanceof FragmentSatu)) {
            mFragmentManager.beginTransaction()
                    .add(R.id.fl_mainFrame, mFragmentSatu, FragmentSatu.class.getSimpleName())
                    .commit();
            activeFragment = 1;
        }

        ArrayList<Button> buttons = new ArrayList<>();
        int[] btnID = {
                R.id.btn_fragment1,
                R.id.btn_fragment2,
        };

        for (int i = 0; i < btnID.length; i++) {
            buttons.add(findViewById(btnID[i]));
            buttons.get(i).setOnClickListener(this);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.btn_fragment1:
                if (activeFragment != 1) {
                    mFragmentManager.beginTransaction()
                            .replace(R.id.fl_mainFrame, new FragmentSatu(), FragmentSatu.class.getSimpleName())
                            .commit();
                    activeFragment = 1;
                }
                break;
            case R.id.btn_fragment2:
                if (activeFragment != 2) {
                    mFragmentManager.beginTransaction()
                            .replace(R.id.fl_mainFrame, new FragmentDua(), FragmentDua.class.getSimpleName())
                            .commit();
                    activeFragment = 2;
                }
                break;
        }
    }

    public static String getStatKd() {
        return statKd;
    }

    public static String getStatYfk() {
        return statYfk;
    }
}
