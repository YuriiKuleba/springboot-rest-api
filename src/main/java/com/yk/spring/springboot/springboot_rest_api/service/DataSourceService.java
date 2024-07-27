package com.yk.spring.springboot.springboot_rest_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceList;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataSourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceService.class);

    private static final String DATA_SOURCE_PARAMETERS_FILENAME = "data-source-parameters.yaml";

    public List<DataSourceProperties> readObjects() {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        DataSourceList dataSourceList = null;

        try {
            dataSourceList = objectMapper
                .readValue(getClass().getResourceAsStream("/" + DATA_SOURCE_PARAMETERS_FILENAME),
                    DataSourceList.class);
        } catch (IOException e) {
            LOGGER.error("Error occurred during receiving datasource parameters", e);
        }

        return dataSourceList.getDataSource();
    }
}
