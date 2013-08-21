package com.ebay;

import com.ebay.Servlet.MainPage;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.net.InetSocketAddress;

public class Launcher {


  public static void main(String[] args) throws Exception {
    Server server = new Server(new InetSocketAddress("0.0.0.0", 8080));

    ServletContextHandler wd = new ServletContextHandler(server, "/homework", true, false);
    wd.addServlet(MainPage.class, "/soduku/*");

    server.start();


  }
}
