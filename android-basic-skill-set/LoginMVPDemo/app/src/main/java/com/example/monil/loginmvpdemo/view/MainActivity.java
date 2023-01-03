package com.example.monil.loginmvpdemo.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.monil.loginmvpdemo.presenter.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILoginView {

    public static final String TAG = MainActivity.class.getName();
    private static LoginPresenter sPresenter;

    @Bind(R.id.layout_email)
    TextInputLayout mEditEmail;
    @Bind(R.id.layout_password)
    TextInputLayout mEditPassword;
    @Bind(R.id.email_login_form)
    View mLoginForm;
    @Bind(R.id.login_progress)
    View mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (sPresenter == null) {//first time creating activity = create presenter
            sPresenter = new LoginPresenter();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onViewDettached();//pausing, detach view from presenter
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onViewAttached(this); //resuming - attach view to presenter
    }

    @OnClick(R.id.email_sign_in_button)
    public void onSigninClicked() {
        getPresenter().login(mEditEmail.getEditText().getText().toString(), mEditPassword.getEditText().getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        Snackbar.make(mLoginForm, "Login successful", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailError(String error) {
        mEditEmail.setError(error);
    }

    @Override
    public void onPasswordError(String error) {
        mEditPassword.setError(error);
    }

    @Override
    public void onGeneralError(String error) {
        Snackbar.make(mLoginForm, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void clearErrors() {
        mEditPassword.setError(null);
        mEditEmail.setError(null);
    }

    @Override
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginForm.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public LoginPresenter getPresenter() {
        return sPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {//activity finishing, release reference to presenter
            sPresenter = null;
        }
    }
}
