package com.jk.client;

import com.jk.pojo.GameBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("producer")
public interface GameClient {

    //游戏开发新增
    @PostMapping("saveGame")
    void saveGame(GameBean gameBean);

    //查询游戏开发
    @PostMapping("queryGameList")
    List<GameBean> queryGameList(GameBean gameBean);

    @PostMapping("findVideo")
    List<GameBean> findVideo();

   /* @RequestMapping("findVideo")
    List<GameBean> findVideo();*/
}
