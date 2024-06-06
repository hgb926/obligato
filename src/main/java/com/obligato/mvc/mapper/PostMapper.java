package com.obligato.mvc.mapper;

import com.obligato.mvc.dto.request.SavePostDto;
import com.obligato.mvc.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<Post> findAll();

    Post findOne(int postId);

    boolean save(Post post);


}
