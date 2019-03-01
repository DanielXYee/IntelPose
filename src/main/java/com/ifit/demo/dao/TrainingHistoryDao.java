package com.ifit.demo.dao;

import com.ifit.demo.entity.TrainingHistory;
import com.ifit.demo.mapper.TrainingHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 9:44 2019/1/23
 * @Modified by:
 */
@Repository
public class TrainingHistoryDao {
    @Autowired
    private TrainingHistoryMapper trainingHistoryMapper;

    /**
     * Description: 新增记录
     * @Author: WinstonDeng
     * @Date: 9:44 2019/1/23
     */
    public Long addTrainingHistory(TrainingHistory trainingHistory){
        return trainingHistoryMapper.insertTrainingHistory(trainingHistory);
    }

    /**
     * Description: 修改基础信息
     * @Author: WinstonDeng
     * @Date: 9:44 2019/1/23
     */
    public boolean updateTrainingHistory(TrainingHistory trainingHistory){
        TrainingHistory temp=trainingHistoryMapper.findById(trainingHistory.getId());
        if(temp==null){
            //TODO 待修正，需要结合异常
            System.out.println("修改训练历史错误！该记录不存在");
            return false;
        }
        temp.setDuration(trainingHistory.getDuration());
        temp.setCalorie(trainingHistory.getCalorie());
        temp.setScore(trainingHistory.getScore());
        temp.setStatus(trainingHistory.getStatus());
        return trainingHistoryMapper.updateById(temp);
    }
    /**
     * Description: 仅修改status
     * @Author: WinstonDeng
     * @Date: 10:01 2019/1/23
     */
    public boolean updateStatus(long id,int status){
        TrainingHistory trainingHistory=trainingHistoryMapper.findById(id);
        if(trainingHistory==null){
            //TODO 待修正，需要结合异常
            System.out.println("修改训练历史错误！该记录不存在");
            return false;
        }
        trainingHistory.setStatus(status);
        return trainingHistoryMapper.updateById(trainingHistory);
    }

    /**
     * Description: 通过id查找
     * @Author: WinstonDeng
     * @Date: 9:45 2019/1/23
     */
    public TrainingHistory getById(long id){
        return trainingHistoryMapper.findById(id);
    }

    /**
     * Description: 通过userId 和 status查找
     * @Author: WinstonDeng
     * @Date: 21:04 2019/1/23
     */
    public List<TrainingHistory> listByUserIdAndStatus(long userId, int status) {
        return trainingHistoryMapper.findByUserIdAndStatus(userId,status);
    }

    /**
     * Description: 通过用户id查找所有
     * @Author: WinstonDeng
     * @Date: 10:05 2019/1/23
     */
    public List<TrainingHistory> listByUserId(long userId){
        return trainingHistoryMapper.findByUserId(userId);
    }
}
