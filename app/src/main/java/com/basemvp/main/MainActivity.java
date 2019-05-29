package com.basemvp.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.basemvp.R;
import com.basemvp.details.DetailsDialog;
import com.basemvp.list.ListFragment;
import com.basemvp.teams.TeamsDialog;
import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseActivity;

public class MainActivity extends MVP_BaseActivity {

    private Button btn_dialog , btn_bottomSheet;


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
        btn_bottomSheet = findViewById(R.id.btn_bottomSheet);
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

        btn_bottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TeamsDialog teamsDialog = new TeamsDialog();
                teamsDialog.show(provideFragmentManager() , teamsDialog.getClass().getSimpleName());

            }
        });
    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return this;
    }


    @Override
    protected void onResume() {
        super.onResume();

        transactionFragment(R.id.container , new ListFragment() , true);
    }
}
