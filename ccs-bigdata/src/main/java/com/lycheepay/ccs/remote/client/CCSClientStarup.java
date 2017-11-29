package com.lycheepay.ccs.remote.client;


import com.lycheepay.ccs.remote.Startup;
import com.lycheepay.ccs.remote.dto.ClearingDTO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/1.
 */
public class CCSClientStarup {
    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {
        Startup startup = (Startup) Naming.lookup("rmi://llj.com:15000/ccsServer");
        ClearingDTO dto = new ClearingDTO();
        dto.setOptType(ClearingDTO.OptType.CLEARING);
        dto.setClearingDate(new Date());
        startup.run("dev", dto);
    }
}
