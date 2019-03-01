package com.ifit.demo.controller;

import com.ifit.demo.entity.TrainingHistory;
import com.ifit.demo.service.TrainingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 9:42 2019/1/23
 * @Modified by:
 */
@RestController
@RequestMapping("/traininghistories")
public class TrainingHistoryController {
    @Autowired
    private TrainingHistoryService trainingHistoryService;

    /**
     * Description: 查找某一个训练历史
     * @Author: WinstonDeng
     * @Date: 10:06 2019/1/23
     */
    @GetMapping("/{traininghistoryId}")
    @ResponseBody
    public TrainingHistory getById(@PathVariable("traininghistoryId") long id){
        if(id<=0){
            System.out.println("id格式错误！");
            return null;
        }
        return trainingHistoryService.getById(id);
    }

    /**
     * Description: 查找用户已完成/未完成/计划中的训练历史
     * @Author: WinstonDeng
     * @Date: 10:09 2019/1/23
     */
    @GetMapping("/status")
    @ResponseBody
    public List<TrainingHistory> listHistoriesByStatus(@RequestParam("userId") long userId,@RequestParam("status") int status){
        //TODO 待修正 结合jwt获取当前用户
        if(status==TrainingHistory.FINISHED||status==TrainingHistory.UNFINISHED||status==TrainingHistory.PLANING){
            return trainingHistoryService.listHistoriesByStatus(userId,status);
        }else {
            System.out.println("status格式错误！");
            return null;
        }
    }

    /**
     * Description: 修改训练历史的状态
     * @Author: WinstonDeng
     * @Date: 10:19 2019/1/23
     */
    @PutMapping("/{traininghistoryId}/status")
    @ResponseBody
    public boolean updateStatusById(@PathVariable("traininghistoryId") long id,@RequestParam("status") int status){
        if(id<=0){
            System.out.println("id格式错误！");
            return false;
        }
        if(status==TrainingHistory.FINISHED||status==TrainingHistory.UNFINISHED||status==TrainingHistory.PLANING){
            return trainingHistoryService.updateStatusById(id,status);
        }else {
            System.out.println("status格式错误！");
            return false;
        }
    }

    /**
     * Description: 开始一项训练，即新增一个记录
     * @Author: WinstonDeng
     * @Date: 10:20 2019/1/23
     */
    @PostMapping()
    @ResponseBody
    public ResponseEntity<Long> addTrainingHistory(@RequestParam("userId") long userId, @RequestParam("videoId") long videoId){
        if(userId<=0){
            System.out.println("userId格式错误！");
            return null;
        }
        if(videoId<=0){
            System.out.println("videoId格式错误！");
            return null;
        }
        return ResponseEntity.ok().body(trainingHistoryService.addTrainingHistory(userId,videoId));
    }

    /**
     * Description: 训练结束后对训练历史信息进行补充
     * @Author: WinstonDeng
     * @Date: 10:19 2019/1/23
     */
    @PutMapping("/{traininghistoryId}/record")
    @ResponseBody
    public ResponseEntity<Boolean> updateRecordById(@PathVariable("traininghistoryId") long id, @RequestBody Map<String,String> infoMap){
        if(id<=0){
            System.out.println("id格式错误！");
            return ResponseEntity.ok().body(false);
        }
        final String duration="duration";
        final String calorie="calorie";
        final String score="score";

        TrainingHistory trainingHistory=new TrainingHistory();
        trainingHistory.setId(id);
        trainingHistory.setDuration(Integer.parseInt(infoMap.get(duration)));
        trainingHistory.setCalorie(Integer.parseInt(infoMap.get(calorie)));
        trainingHistory.setScore(Integer.parseInt(infoMap.get(score)));
        trainingHistory.setStatus(TrainingHistory.FINISHED);
        return ResponseEntity.ok().body(trainingHistoryService.updateRecordById(trainingHistory));
    }
}
