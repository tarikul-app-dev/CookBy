package com.tarikul.cookby.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class UICONTENT {
    public Context mContext;

    // PostSMST postSMST;
    public UICONTENT(Context mContext) {
        this.mContext = mContext;

    }


    public  boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
