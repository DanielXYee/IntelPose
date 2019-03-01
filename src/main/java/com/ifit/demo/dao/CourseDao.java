package com.ifit.demo.dao;

import com.ifit.demo.entity.Course;
import com.ifit.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 10:21 2019/1/23
 * @Modified by:
 */
@Repository
public class CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * Description: 获取所有课程
     * @Author: WinstonDeng
     * @Date: 20:57 2019/1/23
     */
    public List<Course> listAllCourses() {
        return courseMapper.findAll();
    }

    /**
     * Description: 通过courseId查找
     * @Author: WinstonDeng
     * @Date: 21:00 2019/1/23
     */
    public Course getCourseById(long courseId) {
        return courseMapper.findById(courseId);
    }

    /**
     * Description: 通过type查找
     * @Author: WinstonDeng
     * @Date: 21:02 2019/1/23
     */
    public List<Course> listCoursesByType(String type) {
        return courseMapper.findByType(type);
    }
}
