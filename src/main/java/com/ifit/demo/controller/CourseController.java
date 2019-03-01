package com.ifit.demo.controller;

import com.ifit.demo.entity.Course;
import com.ifit.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 10:20 2019/1/23
 * @Modified by:
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * Description: 查看所有课程
     * @Author: WinstonDeng
     * @Date: 10:22 2019/1/23
     */
    @GetMapping()
    @ResponseBody
    public List<Course> listAllCourses(){
        return courseService.listAllCourses();
    }

    /**
     * Description: 查看某一课程
     * @Author: WinstonDeng
     * @Date: 10:22 2019/1/23
     */
    @GetMapping("/{courseId}")
    @ResponseBody
    public ResponseEntity<Course> getCourseById(@PathVariable("courseId")long courseId){
        if(courseId<=0){
            //TODO 待修改 结合异常处理
            System.out.println("courseId格式错误！");
            return null;
        }
        return ResponseEntity.ok().body(courseService.getCourseById(courseId));
    }

    /**
     * Description: 按某一分类查看课程
     * @Author: WinstonDeng
     * @Date: 10:28 2019/1/23
     */
    @GetMapping("/courselist")
    @ResponseBody
    public ResponseEntity<List<Course>> listCoursesByType(@RequestParam("type") String type){
        Set<String> typeSet=Course.typeSetInitial();
        if(!typeSet.contains(type)){
            //TODO 待修改 结合异常处理
            System.out.println("type格式错误！");
            return null;
        }
        return ResponseEntity.ok().body(courseService.listCoursesByType(type));
    }
}
