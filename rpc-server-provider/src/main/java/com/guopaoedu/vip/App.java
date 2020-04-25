package com.guopaoedu.vip;


import com.gupaoedu.vip.IHelloService;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        IHelloService helloService =  new HelloServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(helloService,8080);
    }
}
