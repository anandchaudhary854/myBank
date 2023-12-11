package com.example;
import com.example.context.MyTransactionsApplicationConfiguration;
//import com.example.web.MyFirstServlet;
import jakarta.servlet.ServletContext;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        WebApplicationContext webApplicationContext = createWebApplicationContext(ctx.getServletContext());
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        Wrapper servlet = Tomcat.addServlet(ctx, "dispatcherServlet", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }

    public static WebApplicationContext createWebApplicationContext(ServletContext servletContext){
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyTransactionsApplicationConfiguration.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }
}