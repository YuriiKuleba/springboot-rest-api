package com.yk.spring.springboot.springboot_rest_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceList;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataSourceService {

    private static final String DATA_SOURCE_FILE = "application.yaml";

    public List<DataSourceProperties> readMyObjects() {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        DataSourceList dataSourceList;

        try {
            dataSourceList = objectMapper
                .readValue(getClass().getResourceAsStream("/" + DATA_SOURCE_FILE),
                    DataSourceList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataSourceList.getDataSource();
    }
}
