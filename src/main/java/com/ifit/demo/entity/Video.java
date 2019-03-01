package com.ifit.demo.entity;

/**
 * @Author: WinstonDeng
 * @Description: 视频
 * @Date: Created in 17:43 2019/1/22
 * @Modified by:
 */
public class Video {
    private long id;
    private long courseId;
    private String intro;
    private String name;
    private String path;
    private String poseFileName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPoseFileName() {
        return poseFileName;
    }

    public void setPoseFileName(String poseFileName) {
        this.poseFileName = poseFileName;
    }

}
