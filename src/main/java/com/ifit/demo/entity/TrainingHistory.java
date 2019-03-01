package com.ifit.demo.entity;

/**
 * @Author: WinstonDeng
 * @Description: 训练历史
 * @Date: Created in 17:11 2019/1/22
 * @Modified by:
 */
public class TrainingHistory {
    private long id;
    private long userId;
    private long videoId;
    private Integer duration;
    private Integer calorie;
    private Integer score;
    private Integer status;

    public static final int UNFINISHED=0;
    public static final int FINISHED=1;
    public static final int PLANING=2;

    //关系

    private User user;
    private Video video;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
