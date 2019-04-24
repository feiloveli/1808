package com.jk.service;

import com.jk.pojo.GameBean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GameService {

    //游戏开发新增
    void saveGame(GameBean gameBean);

    //查询游戏开发
    List<GameBean> queryGameList(GameBean gameBean);


    List<GameBean> findVideo();

}
