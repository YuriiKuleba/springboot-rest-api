package com.yk.spring.springboot.springboot_rest_api.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "dataSource")
public class DataSourceProperties{
    public String url;
    public String username;
    public String password;
    public String driverClassName;

    public String getUrl() {
        return url;
    }

    public DataSourceProperties() {
    }

    public DataSourceProperties(String url, String username, String password, String driverClassName) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "DataSourceProperties{" + "url='" + url + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", driverClassName='" + driverClassName + '\'' +
            '}';
    }
}
