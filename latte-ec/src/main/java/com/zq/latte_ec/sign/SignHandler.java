package com.zq.latte_ec.sign;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zq.latte_core.app.AccountManager;
import com.zq.latte_ec.database.DatabaseManager;
import com.zq.latte_ec.database.UserProfile;
import com.zq.latte_ec.http.responsebean.BaseBean;
import com.zq.latte_ec.http.responsebean.LoginBean;
import com.zq.latte_ec.http.responsebean.User;


public class SignHandler {

    public static void onSignIn(String response) {
        BaseBean<LoginBean> bean = new Gson()
                .fromJson(response, new TypeToken<BaseBean<LoginBean>>() {
                }.getType());
        User user =
                bean.getData().getUser();

        final UserProfile profile = new UserProfile(user.getId(), user.getId(), user.getEmail(), user.getLogo_url(), user.getUsername(), user.getMobi());
        DatabaseManager.getInstance().getDao().insert(profile);


        AccountManager.setSignState(true);
    }


}
