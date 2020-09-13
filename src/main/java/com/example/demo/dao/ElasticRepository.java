package com.example.demo.dao;

import com.example.demo.po.RobotPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<RobotPo, Long> {

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"label.keyword\" : \"?\"}}}}")
    Page<RobotPo> findByLabel(String label, Pageable pageable);

}
