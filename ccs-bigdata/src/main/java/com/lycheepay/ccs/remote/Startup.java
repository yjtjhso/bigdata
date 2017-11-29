package com.lycheepay.ccs.remote;

import com.lycheepay.ccs.remote.dto.ClearingDTO;

import java.rmi.Remote;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface Startup extends Remote {
    public void run(String env, ClearingDTO clearingDTO);

    /*public void syncTradeRecord(ClearingDTO clearingDTO);
    public void clearing(ClearingDTO clearingDTO);
    public void reclearing(ClearingDTO clearingDTO);
    public void genSettlement(ClearingDTO clearingDTO);*/
}
