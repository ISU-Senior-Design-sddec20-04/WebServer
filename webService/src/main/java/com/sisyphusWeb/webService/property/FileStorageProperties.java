package com.sisyphusWeb.webService.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String storageDir;

    public String getStorageDir() {
        return storageDir;
    }

    public void setStorageDir(String uploadDir) {
        this.storageDir = uploadDir;
    }
}
