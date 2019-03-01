package com.ifit.demo.mapper;

import com.ifit.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 17:15 2019/1/22
 * @Modified by:
 */
@Mapper
@Repository
public interface CourseMapper {
    /**
     * 通过id查找
     * @param id
     * @return
     */
    Course findById(long id);

    /**
     * 新增课程
     * @param course
     * @return
     */
    Long insertCourse(Course course);

    /**
     * 通过type查找
     * @param type
     * @return
     */
    List<Course> findByType(String type);

    /**
     * 获取所有
     * @return
     */
    List<Course> findAll();
}
