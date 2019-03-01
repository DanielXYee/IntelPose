package com.ifit.demo.service;

import com.ifit.demo.dao.CourseDao;
import com.ifit.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 10:21 2019/1/23
 * @Modified by:
 */
@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    /**
     * Description: 获取所有课程
     * @Author: WinstonDeng
     * @Date: 20:57 2019/1/23
     */
    public List<Course> listAllCourses() {
        return courseDao.listAllCourses();
    }

    /**
     * Description: 通过id查找
     * @Author: WinstonDeng
     * @Date: 20:59 2019/1/23
     */
    public Course getCourseById(long courseId) {
        return courseDao.getCourseById(courseId);
    }

    /**
     * Description: 通过type查找
     * @Author: WinstonDeng
     * @Date: 21:01 2019/1/23
     */
    public List<Course> listCoursesByType(String type) {
        return courseDao.listCoursesByType(type);
    }
}
