package com.user.base;

import com.hotPoint.HotPointListInterface;
import com.scannerTool.ReadOption;

public class User {

    private final HotPointListInterface hotPointList;

    /**
     * 构造函数
     * @param hotPointList 热搜列表对象
     */
    public User(HotPointListInterface hotPointList) {
        this.hotPointList = hotPointList;
    }

    /**
     * 添加热搜
     * @param hotPointName 热搜名称
     */
    protected void createHotPoint(String hotPointName) {
        this.hotPointList.addHotPoint(hotPointName, false);
    }

    /**
     * 查看热搜
     */
    protected void seeHotPoint() {
        this.hotPointList.hotPointShow();
    }

    /**
     * 获取热搜列表对象
     * @return HotPointList
     */

    protected HotPointListInterface getHotPointList(){
        return this.hotPointList;
    }

    /**
     * 添加热搜控制函数
     */
    protected void addMenu(){
        System.out.println("请输入需要添加的热搜:");
        try {
            String hotPoint = ReadOption.catStr();
            this.createHotPoint(hotPoint);
            System.out.println("热搜添加成功！");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
