package com.lycheepay.ccs.remote.server;

import com.lycheepay.ccs.remote.Startup;
import com.lycheepay.ccs.remote.impl.Startup4ccs;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Administrator on 2017/10/31.
 */
public class CCSServerStartup {
    private static String ip = "llj.com";
    private static int port = 15000;
    private static String url="rmi://"+ip+":"+port+"/ccsServer";
    public static void main(String args[]) {
        Startup startup = new Startup4ccs();
        try {
            LocateRegistry.createRegistry(port);
            Naming.bind(url,startup);
//            startup.wait();
            System.out.println("ccs服务器："+ip+"启动成功");
            while (true) {
                Thread.sleep(Long.MAX_VALUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ccs服务器："+ip+"启动失败--------------");
        }
        System.out.println("ccs服务器已退出--------------");
    }
}
