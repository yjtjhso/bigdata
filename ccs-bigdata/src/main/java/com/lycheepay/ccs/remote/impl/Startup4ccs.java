package com.lycheepay.ccs.remote.impl;

import com.lycheepay.ccs.Start$;
import com.lycheepay.ccs.remote.Startup;
import com.lycheepay.ccs.remote.dto.ClearingDTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/31.
 */
public class Startup4ccs implements Startup,Serializable {
//    private String env = "dev";
    public void run(String env, ClearingDTO clearingDTO){
        Start$.MODULE$.run(env, clearingDTO);
    }
}
