package com.yk.spring.springboot.springboot_rest_api.model;

import java.util.List;

public class DataSourceList {

    private List<DataSourceProperties> dataSource;

    public List<DataSourceProperties> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<DataSourceProperties> dataSource) {
        this.dataSource = dataSource;
    }

}
