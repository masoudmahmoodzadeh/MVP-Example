package com.basemvp.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basemvp.main.MainActivity;
import com.basemvp.R;
import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseActivity;

public class LoginActivity extends MVP_BaseActivity implements Login_IView {

    private EditText ed_username, ed_password;
    private Button btn_login;

    private Login_Presenter<Login_IView> loginPresenter;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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

        loginPresenter = new Login_Presenter<>(repository());
        loginPresenter.onAttach(this);
    }

    @Override
    public void findView() {

        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);

        btn_login = findViewById(R.id.btn_login);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setSlideMenu() {

    }

    @Override
    public void onClick() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = ed_username.getText().toString();
                String password = ed_password.getText().toString();

                if (!username.isEmpty() && !password.isEmpty()) {

                    hideKeyboard();

                    loginPresenter.server_login(username, password);


                } else
                    showMessage("Please enter username and password");

            }
        });

    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return this;
    }

    @Override
    public void onSuccessLogin() {

        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);

        finish();
    }
}
