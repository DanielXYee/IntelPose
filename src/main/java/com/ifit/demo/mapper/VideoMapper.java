package com.ifit.demo.mapper;

import com.ifit.demo.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 17:44 2019/1/22
 * @Modified by:
 */
@Mapper
@Repository
public interface VideoMapper {
    /**
     * 通过id查找
     * @param id
     * @return
     */
    Video findById(long id);

    /**
     * 新增
     * @param video
     * @return
     */
    Long insertVideo(Video video);

    /**
     * 通过courseId查找
     * @param courseId
     * @return
     */
    List<Video> findByCourseId(long courseId);
}
