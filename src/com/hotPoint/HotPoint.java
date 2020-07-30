package com.hotPoint;

public class HotPoint {
    private int hot = 0;
    private final String hotPointName;
    private final int hotPointID;

    private int order = 0;
    private int price = 0;

    private final boolean superHotFlag;

    /**
     * 构造函数
     * @param hotPointName 热搜名称
     * @param superHotFlag 超级热搜标志
     * @param hotPointID 热搜ID
     */
    public HotPoint(String hotPointName, boolean superHotFlag, int hotPointID) {
        this.hotPointName = hotPointName;
        this.superHotFlag = superHotFlag;
        this.hotPointID = hotPointID;
    }

    /**
     * 为该热搜投票
     */
    public void vote(int votes) {
        if (superHotFlag){
            hot += 2 * votes;
        }
        else hot += votes;
    }

    public int getHot() {
        return hot;
    }

    public int getHotPointID() {
        return hotPointID;
    }

    public int getPrice() {
        return price;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 展示此条热搜
     * @return 热手信息格式化输出
     */
    public String show() {
        return (superHotFlag ? "超级":"")+"热搜: ["+hotPointName+"] 热度: ["+hot+"]"+ " 热搜ID: ["+ hotPointID+"]";
    }

    @Override
    public String toString() {
        return "HotPoint{" +
                "hot=" + hot +
                ", hotPointName='" + hotPointName + '\'' +
                ", hotPointID=" + hotPointID +
                ", price=" + price +
                ", superHotFlag=" + superHotFlag +
                '}';
    }
}
