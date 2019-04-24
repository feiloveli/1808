package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.client.GameClient;
import com.jk.pojo.GameBean;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 页面升序降序
 */
@RestController
@RequestMapping("curriculum")
public class CurriculumController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GameClient curriculumServiceApl;


    @Scheduled(fixedRate = 20000)//定时器注解
    @ResponseBody
    public void findRedisVideo() {

        List<GameBean> videoBeanList = curriculumServiceApl.findVideo();

       Collections.sort(videoBeanList, new Comparator<GameBean>(){
                     /*
28              * int compare(Student o1, Student o2) 返回一个基本类型的整型，
29              * 返回负数表示：o1 小于o2，
30              * 返回0 表示：o1和o2相等，
31              * 返回正数表示：o1大于o2。
32              */
                     public int compare(GameBean o1, GameBean o2) {
                             if(Integer.parseInt(o1.getPrice()) > Integer.parseInt(o2.getPrice())){
                                     return 1;
                                 }
                             if(Integer.parseInt(o1.getPrice()) > Integer.parseInt(o2.getPrice())){
                                     return 0;
                                 }
                             return -1;
                         }
                 });
        redisTemplate.opsForValue().set("findRedisVideo_key",videoBeanList);
     }


     @ResponseBody
    @RequestMapping("getKey")
    public JSONObject getKey(){
         List<GameBean> videoBeanList = new ArrayList<GameBean>();
         JSONObject result = new JSONObject();
         List<GameBean> videoKey = (List<GameBean>)redisTemplate.opsForValue().get("findRedisVideo_key");
         result.put("rows",videoKey);
         return result;
     }

     /*--------------------------------降序-----------------------------------------------------*/

    @Scheduled(fixedRate = 20000)//定时器注解
    @ResponseBody
    public void findVideo() {

        List<GameBean> videoBeanList = curriculumServiceApl.findVideo();

        Collections.sort(videoBeanList, new Comparator<GameBean>(){
            /*
28              * int compare(Student o1, Student o2) 返回一个基本类型的整型，
29              * 返回负数表示：o1 小于o2，
30              * 返回0 表示：o1和o2相等，
31              * 返回正数表示：o1大于o2。
32              */
            public int compare(GameBean o1, GameBean o2) {
                if(Integer.parseInt(o1.getPrice()) < Integer.parseInt(o2.getPrice())){
                    return 1;
                }
                if(Integer.parseInt(o1.getPrice()) == Integer.parseInt(o2.getPrice())){
                    return 0;
                }
                return -1;
            }
        });
        redisTemplate.opsForValue().set("findRedisVideo_key_One",videoBeanList);
    }


    @ResponseBody
    @RequestMapping("findKey")
    public JSONObject findKey(){
        List<GameBean> videoBeanList = new ArrayList<GameBean>();
        JSONObject result = new JSONObject();
        List<GameBean> videoKey = (List<GameBean>)redisTemplate.opsForValue().get("findRedisVideo_key_One");
        result.put("rows",videoKey);
        return result;
    }

}
