package com.ifit.demo.service;

import com.ifit.demo.dao.TrainingHistoryDao;
import com.ifit.demo.entity.TrainingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 9:43 2019/1/23
 * @Modified by:
 */
@Service
public class TrainingHistoryService {
    @Autowired
    private TrainingHistoryDao trainingHistoryDao;

    /**
     * Description: 通过id查找
     * @Author: WinstonDeng
     * @Date: 21:03 2019/1/23
     */
    public TrainingHistory getById(long id) {
        return trainingHistoryDao.getById(id);
    }

    /**
     * Description: 通过status查找当前用户的训练记录
     * @Author: WinstonDeng
     * @Date: 21:03 2019/1/23
     */
    public List<TrainingHistory> listHistoriesByStatus(long userId, int status) {
        return trainingHistoryDao.listByUserIdAndStatus(userId,status);
    }

    /**
     * Description: 修改status
     * @Author: WinstonDeng
     * @Date: 21:09 2019/1/23
     */
    public boolean updateStatusById(long id, int status) {
        return trainingHistoryDao.updateStatus(id,status);
    }

    /**
     * Description: 新增
     * @Author: WinstonDeng
     * @Date: 21:09 2019/1/23
     */
    public Long addTrainingHistory(long userId, long videoId) {
        TrainingHistory trainingHistory=new TrainingHistory();
        trainingHistory.setUserId(userId);
        trainingHistory.setVideoId(videoId);
        trainingHistory.setStatus(TrainingHistory.UNFINISHED);
        return trainingHistoryDao.addTrainingHistory(trainingHistory);
    }

    /**
     * Description: 修改durarion calorie score
     * @Author: WinstonDeng
     * @Date: 21:14 2019/1/23
     */
    public boolean updateRecordById(TrainingHistory trainingHistory) {
        return trainingHistoryDao.updateTrainingHistory(trainingHistory);
    }
}
