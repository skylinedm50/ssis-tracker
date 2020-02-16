package com.example.ssis_tracker.api;

public class ConfigAPI {
   private String Port;
   private String IPExterna;
   private String IPinterna;
   private String URL;

    public ConfigAPI() {
        Port = "";
        IPExterna = "";
        IPinterna = "";
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
