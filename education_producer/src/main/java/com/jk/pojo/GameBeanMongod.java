package com.jk.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "t_game")
public class GameBeanMongod  {
    private String id;

    private String img;        //图片

    private String name;       //名称

    private String introduce;  //介绍

    private String type;        //类型

    private String price;       //价格

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GameBeanMongod{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
