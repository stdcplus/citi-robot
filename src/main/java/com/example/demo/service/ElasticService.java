package com.example.demo.service;

import com.example.demo.dao.ElasticRepository;
import com.example.demo.po.RobotPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private static Pageable pageable = PageRequest.of(0,10);

    public void createIndex() {
        elasticsearchTemplate.createIndex(RobotPo.class);
    }

    public void save(RobotPo robotPo) {
        elasticRepository.save(robotPo);
    }

    public Page<RobotPo> findByLabel(String label){
        return elasticRepository.findByLabel(label, pageable);
    }

    public void saveAll(List<RobotPo> list) {
        elasticRepository.saveAll(list);
    }

    public Iterator<RobotPo> findAll() {
        return elasticRepository.findAll().iterator();
    }
}
