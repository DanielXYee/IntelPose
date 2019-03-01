package com.ifit.demo.dao;

import com.ifit.demo.entity.Video;
import com.ifit.demo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 8:54 2019/1/23
 * @Modified by:
 */
@Repository
public class VideoDao {
    @Autowired
    private VideoMapper videoMapper;

    /**
     * Description: 新增
     * @Author: WinstonDeng
     * @Date: 20:53 2019/1/23
     */
    public Long addVideo(Video video){
        videoMapper.insertVideo(video);
        return video.getId();
    }

    /**
     * Description: 通过id查找
     * @Author: WinstonDeng
     * @Date: 20:53 2019/1/23
     */
    public Video getById(long videoId) {
        return videoMapper.findById(videoId);
    }

    /**
     * Description: 通过courseId查找
     * @Author: WinstonDeng
     * @Date: 20:54 2019/1/23
     */
    public List<Video> listByCourseId(long courseId) {
        return videoMapper.findByCourseId(courseId);
    }
}
