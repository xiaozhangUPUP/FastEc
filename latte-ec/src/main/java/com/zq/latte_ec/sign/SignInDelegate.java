package com.zq.latte_ec.sign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.zq.latte_core.delegates.LatteDelegate;
import com.zq.latte_core.net.RestClient;
import com.zq.latte_core.net.callback.IError;
import com.zq.latte_core.net.callback.IFailure;
import com.zq.latte_core.net.callback.ISuccess;
import com.zq.latte_ec.R;
import com.zq.latte_ec.R2;
import com.zq.latte_ec.http.requestbean.LoginRequestBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqi on 2019/10/31
 */
public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
    }

    @OnClick({R2.id.btn_sign_in, R2.id.tv_link_sign_up, R2.id.icon_sign_in_wechat})
    public void onViewClicked(View view) {
        int rId = view.getId();
        if (rId == R.id.btn_sign_in) {
            if (checkForm()) {
                LoginRequestBean loginRequestBean = new LoginRequestBean(mEmail.getText().toString(),
                        mPassword.getText().toString());
                RestClient.builder()
                        .loader(getContext())
                        .url("login")
                        .raw(JSONObject.toJSONString(loginRequestBean))
                        .success(new ISuccess() {
                            @Override
                            public void onSuccess(String response) {
                                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                                SignHandler.onSignIn(response);
                            }
                        })
                        .error(new IError() {
                            @Override
                            public void onError(int code, String msg) {
                                Toast.makeText(getContext(), "onError code: " + code + " , msg: " + msg, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .failure(new IFailure() {
                            @Override
                            public void onFailure() {
                                Toast.makeText(getContext(), "onFailure", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .post();


                //                RestCreator.getApiService()
                //                        .login(new LoginRequestBean(mEmail.getText().toString(),
                //                                mPassword.getText().toString()))
                //                        .compose(RxHttpResponseCompose.<LoginBean>compatResult())
                //                        .subscribe(new Observer<LoginBean>() {
                //                            @Override
                //                            public void onSubscribe(Disposable d) {
                //
                //                            }
                //
                //                            @Override
                //                            public void onNext(LoginBean loginBean) {
                //                                Toast.makeText(mActivity, JSONObject.toJSONString(loginBean), Toast.LENGTH_SHORT).show();
                //                            }
                //
                //                            @Override
                //                            public void onError(Throwable e) {
                //
                //                            }
                //
                //                            @Override
                //                            public void onComplete() {
                //
                //                            }
                //                        });
            }
        } else if (rId == R.id.tv_link_sign_up) {
            start(new SignUpDelegate());
        } else if (rId == R.id.icon_sign_in_wechat) {
        }
    }


    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
}
