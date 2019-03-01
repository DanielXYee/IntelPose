package com.ifit.demo.service;

import com.ifit.demo.dao.VideoDao;
import com.ifit.demo.entity.Video;
import com.ifit.demo.utils.FileLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 8:49 2019/1/23
 * @Modified by:
 */
@Service
public class VideoService {
    @Autowired
    private VideoDao videoDao;

    /**
     * Description: 上传视频及动作文件
     * @Author: WinstonDeng
     * @Date: 9:10 2019/1/23
     */
    public Long upLoadVideo(String videoPath, MultipartFile video, MultipartFile poseFile,long courseId,String intro){
        List<MultipartFile> files=new ArrayList<>();
        files.add(video);
        files.add(poseFile);
        FileLoadUtils.uploadFileList(files,videoPath);
        Video tempVideo=new Video();
        tempVideo.setCourseId(courseId);
        tempVideo.setName(video.getOriginalFilename());
        tempVideo.setPath(videoPath);
        tempVideo.setPoseFileName(poseFile.getOriginalFilename());
        tempVideo.setIntro(intro);
        return videoDao.addVideo(tempVideo);
    }

    /**
     * Description:
     * @Author: WinstonDeng
     * @Date: 20:29 2019/2/26
     */
    public Long upLoaPose(String videoPath, String name,long courseId,String intro){

        Video tempVideo=new Video();
        tempVideo.setCourseId(courseId);
        tempVideo.setName(name+"Video");
        tempVideo.setPath(videoPath);
        tempVideo.setPoseFileName(name);
        tempVideo.setIntro(intro);
        return videoDao.addVideo(tempVideo);
    }

    /**
     * Description: 通过id查找
     * @Author: WinstonDeng
     * @Date: 20:52 2019/1/23
     */
    public Video getById(long videoId) {
        return videoDao.getById(videoId);
    }

    /**
     * Description: 通过courseId查找
     * @Author: WinstonDeng
     * @Date: 20:53 2019/1/23
     */
    public List<Video> listVideosByCourseId(long courseId) {
        return videoDao.listByCourseId(courseId);
    }
}
