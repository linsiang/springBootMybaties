package com.gnnu.springbootmybaties.mapper;

import com.gnnu.springbootmybaties.pojo.Poetry;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PoetryMapper {
    @Select("select poetry_id, poetry_title,poetry_body,poetry_author,poetry_dynasty from poetry")
/*    @Results({
            @Result(property = "poetryId",column = "poetry_id" ),
            @Result(property = "poetryTitle",column = "poetry_title" ),
            @Result(property = "poetryBody",column = "poetry_body" ),
            @Result(property = "poetryAuthor",column = "poetry_author" ),
            @Result(property = "poetryDynasty",column = "poetry_dynasty" )
    })*/
    List<Poetry> findall();

    @Delete("delete from poetry where poetry_id=#{poetryId}")
    int deletePoetryById(String poetryId);

    @Select("select poetry_id, poetry_title,poetry_body,poetry_author,poetry_dynasty from poetry where poetry_id=#{poetryId}")
    Poetry findById(String poetryId);

    @Update("update poetry set poetry_title=#{poetryTitle},poetry_body=#{poetryBody},poetry_author=#{poetryAuthor},poetry_dynasty=#{poetryDynasty} where poetry_id=#{poetryId}")
    int editPoetry(Poetry poetry);

    @Insert("insert into poetry(poetry_title,poetry_body,poetry_author,poetry_dynasty) value(#{poetryTitle},#{poetryBody},#{poetryAuthor},#{poetryDynasty})")
    int addPoetry(Poetry poetry);
}
