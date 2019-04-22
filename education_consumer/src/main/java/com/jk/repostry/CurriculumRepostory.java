package com.jk.repostry;


import com.jk.pojo.GameBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface CurriculumRepostory extends ElasticsearchCrudRepository<GameBean,String> {
}
