package com.guopaoedu.vip;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService executorService= Executors.newCachedThreadPool();

    public void publisher(Object service,int port) throws IOException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(port);
        while(true){
            Socket socket = serverSocket.accept();
            //每一个socket 交给一个processorHandler来处理
            executorService.execute(new ProcessorHandler(socket,service));
        }

    }
}
