package com.jk.mapper;

import com.jk.pojo.GameBean;

import java.util.List;

public interface GameMapper {

    //游戏开发新增
    void saveGame(GameBean gameBean);

    //查询游戏开发
    List<GameBean> queryGameList(GameBean gameBean);

}
