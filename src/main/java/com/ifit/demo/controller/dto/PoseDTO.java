package com.ifit.demo.controller.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 20:00 2019/2/26
 * @Modified by:
 */
public class PoseDTO implements Serializable {
    private Double score;
    private List<KeyPoint> keypoints;
    private Double time;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<KeyPoint> getKeypoints() {
        return keypoints;
    }

    public void setKeypoints(List<KeyPoint> keypoints) {
        this.keypoints = keypoints;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }


}

class KeyPoint implements Serializable{
    private Double score;
    private String part;
    private Position position;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
class Position implements Serializable{
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

}
