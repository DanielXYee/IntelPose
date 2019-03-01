package com.ifit.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ifit.demo.controller.dto.PoseDTO;
import com.ifit.demo.entity.Video;
import com.ifit.demo.service.VideoService;
import com.ifit.demo.utils.CreateFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 9:00 2019/1/23
 * @Modified by:
 */
@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * Description: 上传视频及动作文件
     * @Author: WinstonDeng
     * @Date: 9:10 2019/1/23
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Long> uploadVideo(HttpServletRequest request, @RequestParam("video")MultipartFile video, @RequestParam("poseFile") MultipartFile poseFile, @RequestParam("courseId") long courseId, @RequestParam("intro") String intro){
        return ResponseEntity.ok().body(videoService.upLoadVideo(request.getServletContext().getRealPath("/resources/video/"),video,poseFile,courseId,intro));
    }

    /**
     * Description: 上传动作文件
     * @Author: WinstonDeng
     * @Date: 19:53 2019/2/26
     */
    @PostMapping("uploadPose")
    @ResponseBody
    public ResponseEntity<Long> uploadPose(HttpServletRequest request, @RequestParam("courseId") long courseId, @RequestParam("intro") String intro, @RequestParam("name") String name, @RequestBody List<PoseDTO> poseDTOS){
        String jsonString = JSON.toJSONString(poseDTOS);
        CreateFileUtil.createJsonFile(jsonString, request.getServletContext().getRealPath("/resources/video/"), name);
        return ResponseEntity.ok().body(videoService.upLoaPose( request.getServletContext().getRealPath("/resources/video/"),name,courseId,intro));
    }

    /**
     * Description: 查看某一课程下的所有视频
     * @Author: WinstonDeng
     * @Date: 10:10 2019/1/23
     */
    @GetMapping()
    @ResponseBody()
    public ResponseEntity<List<Video>> listVideosByCourseId(@RequestParam("courseId") long courseId){
        if(courseId<=0){
            System.out.println("courseId格式错误！");
            return null;
        }
        return ResponseEntity.ok().body(videoService.listVideosByCourseId(courseId));
    }

    /**
     * Description: 查看某一视频 包括视频本身+动作文件（解析成包体的一部分放进去?）
     * @Author: WinstonDeng
     * @Date: 10:18 2019/1/23
     */
    @GetMapping("/{videoId}")
    @ResponseBody
    public ResponseEntity<Video> getById(@PathVariable("videoId") long videoId){
        if(videoId<=0){
            System.out.println("videoId格式错误！");
            return null;
        }
        return ResponseEntity.ok().body(videoService.getById(videoId));
    }

}
