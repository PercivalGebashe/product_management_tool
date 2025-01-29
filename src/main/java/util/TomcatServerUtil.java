package util;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatServerUtil {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void startServer() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8069);
        tomcat.getConnector();

        String webAppDir = PROJECT_DIR+"\\src\\main\\webapp";
        tomcat.addWebapp("",webAppDir);

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();
    }
}
