package com.basemvp.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.basemvp.R;
import com.basemvp.details.DetailsDialog;
import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseActivity;

public class MainActivity extends MVP_BaseActivity {

    private Button btn_dialog;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MVP_AnimationUtils getAnimationTransition() {
        return null;
    }

    @Override
    public void createActionbar() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void findView() {

        btn_dialog = findViewById(R.id.btn_dialog);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setSlideMenu() {

    }

    @Override
    public void onClick() {

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DetailsDialog detailsDialog = new DetailsDialog();
                detailsDialog.show(provideFragmentManager() , detailsDialog.getClass().getSimpleName());
            }
        });
    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return this;
    }
}
