package com.obligato.mvc.mapper;

import com.obligato.mvc.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<Post> findAll();

    boolean save(Post post);

}