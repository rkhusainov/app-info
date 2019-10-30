package com.khusainov.rinat.appinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PackageInfoHolder{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.package_info_fragment, new StubFragment())
                    .commit();
        }
    }

    @Override
    public void showPackageInfo(String packageName) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.package_info_fragment,
                        PackageInfoFragment.newInstance(packageName))
                .commit();
    }
}
