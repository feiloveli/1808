package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.client.GameClient;
import com.jk.pojo.GameBean;
import com.jk.repostry.CurriculumRepostory;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.elasticsearch.common.text.Text;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("game")
public class GameContorller {

    @Autowired
    private GameClient gameClient;

    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private CurriculumRepostory curriculumRepostory;

    //跳转游戏开发
    @RequestMapping("toList")
    public String toList(){
        return "gameList";
    }

    /**
     * 跳转新增
     */
    @RequestMapping("addGame")
    public String addGame() {
        return "gameAdd";
    }

    /**
     * 新增修改
     */
    @RequestMapping("saveGame")
    @ResponseBody
    public Boolean saveGame(GameBean gameBean) {
        if(gameBean.getId() == null) {
            try {
                //如果有id则修改，没有则新增
                gameClient.saveGame(gameBean);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    //跳转游戏开发主页面
    @RequestMapping("toGame")
    public String toGame(){
        return "list";
    }

    //查询游戏开发
    @RequestMapping("queryGameList")
    @ResponseBody
    public List<GameBean> queryGameBean(GameBean gameBean){
        List<GameBean> queryGameBean = gameClient.queryGameList(gameBean);
        return queryGameBean;
    }

    //ES检索
    @ResponseBody
    @RequestMapping("queryGame")
    public JSONObject queryVideo(Integer page, Integer rows, GameBean video){
        System.out.println("==================================="+video.getName());
        JSONObject result = new JSONObject();
        Client client = elasticsearchTemplate.getClient();
        //  Integer startIndex = rows*(page-1);

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("gamee").setTypes("gameindex");
        if(video.getName() !=null && video.getName() != "" ){
            searchRequestBuilder.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", video.getName())));
        }
        //  searchRequestBuilder.setFrom(startIndex).setSize(rows);
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.preTags("<font color='red' >");
        highlightBuilder.postTags("</font>");
        searchRequestBuilder.highlighter(highlightBuilder);

        SearchResponse searchResponse = searchRequestBuilder.get();

        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits();

        Iterator<SearchHit> iterator = hits.iterator();

        List<GameBean> list = new ArrayList<GameBean>();

        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            Map<String, HighlightField> highlightFields = next.getHighlightFields();

            String sourceAsString = next.getSourceAsString();
            HighlightField videoname = highlightFields.get("name");
            GameBean videoBean = JSON.parseObject(sourceAsString, GameBean.class);
            //取得定义的高亮标签
            if(videoname !=null) {
                Text[] fragments = videoname.fragments();
                //为thinkName（相应字段）增加自定义的高亮标签
                String title = "";
                for (Text text1 : fragments) {
                    title += text1;
                }
                videoBean.setName(title);
            }
            list.add(videoBean);
        }
        result.put("total",total);
        result.put("rows",list);
        return result;
    }

   @Scheduled(fixedRate = 2000)//定时器注解
    @ResponseBody
    public void testTasks(){
        List<GameBean> list = gameClient.findVideo();
        // System.out.println("==========================定时器执行任务===========================");
        for (GameBean user:list){
            curriculumRepostory.save(user);
        }
    }

    //跳转游戏开发详情页面
    @RequestMapping("toDetails")
    public String toDetails(){
        return "detailsList";
    }

    //查询游戏开发详情
    @RequestMapping("queryOrder")
    @ResponseBody
    public GameBean queryOrder(String id){
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("gamee").setTypes("gameindex").setQuery(QueryBuilders.matchQuery("id",id));
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        SearchHit next = iterator.next();
        String sourceAsString = next.getSourceAsString();
        GameBean housBean1 = JSON.parseObject(sourceAsString, GameBean.class);
        return housBean1;
    }


}
