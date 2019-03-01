package com.ifit.demo.mapper;

import com.ifit.demo.entity.TrainingHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 17:15 2019/1/22
 * @Modified by:
 */
@Mapper
@Repository
public interface TrainingHistoryMapper {
    /**
     * 通过id查找
     * @param id
     * @return
     */
    TrainingHistory findById(long id);

    /**
     * 通过user_id查找
     * @param userId
     * @return
     */
    List<TrainingHistory> findByUserId(long userId);

    /**
     * 新增
     * @param trainingHistory
     * @return
     */
    Long insertTrainingHistory(TrainingHistory trainingHistory);

    /**
     * 修改
     * @param trainingHistory
     * @return
     */
    boolean updateById(TrainingHistory trainingHistory);

    /**
     * 通过status查找用户下的训练记录
     * @param userId
     * @param status
     * @return
     */
    List<TrainingHistory> findByUserIdAndStatus(@Param("userId") long userId,@Param("status") int status);
}
