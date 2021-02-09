package com.example.website;

import com.example.website.model.UserInfo;

public final class MySingleton {
    private UserInfo userinfo;
    private static volatile MySingleton INSTANCE ;

    private MySingleton(){}
    public static synchronized MySingleton getInstance(){

               if (INSTANCE == null){
                   INSTANCE= new MySingleton();
               }


       return INSTANCE ;
    }

    public UserInfo getUserInfo()
    {
        return userinfo;
    }
    public UserInfo setUserInfo(UserInfo userinfo){
        return this.userinfo=userinfo;
    }


}
