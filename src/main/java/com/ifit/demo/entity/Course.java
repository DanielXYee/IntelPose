package com.ifit.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: WinstonDeng
 * @Description: 课程
 * @Date: Created in 17:09 2019/1/22
 * @Modified by:
 */
public class Course {
    private long id;
    private String name;
    private String type;
    private String intro;

    private List<Video> videos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public static Set<String> typeSetInitial(){
        final String ARM="arm";
        final String LEG="leg";
        final String HIP="hip";
        final String CHEST="chest";
        final String BACK="back";
        Set<String> typeSet=new HashSet<>();
        typeSet.add(ARM);
        typeSet.add(LEG);
        typeSet.add(HIP);
        typeSet.add(CHEST);
        typeSet.add(BACK);
        return typeSet;
    }
}
