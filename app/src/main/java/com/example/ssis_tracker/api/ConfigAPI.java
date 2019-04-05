package com.example.ssis_tracker.api;

public class ConfigAPI {
   private String Port;
   private String IPExterna;
   private String IPinterna;
   private String URL;

    public ConfigAPI() {
        Port = "3005";
        IPExterna = "190.6.200.98";
        IPinterna = "192.168.90.23";
    }

    public String getPort() {
        return Port;
    }

    public String getIPExterna() {
        return IPExterna;
    }

    public String getURL() {
        String Protocolo = "http://";
        String Home = "/index.php/";
        String doublePoint = ":";

        URL = Protocolo + IPinterna + doublePoint + Port + Home;
        return URL;
    }
}
