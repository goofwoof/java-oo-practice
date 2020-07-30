package com.hotPoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HotPointListIml implements HotPointListInterface {
    private int hotID = 0;
    //一个热搜可以由ID唯一确定，且只会存在于两个List的其中一个
    private final List<HotPoint> normalHotPoint = new ArrayList<>();
    private final List<HotPoint> moneyHotPoint = new ArrayList<>();

    /**
     * 展示热搜
     */
    public void hotPointShow() {
        this.hotPointListSort();
        AtomicInteger order = new AtomicInteger(1);
        moneyHotPoint.forEach(hotPoint -> {System.out.println(order+" "+ hotPoint.show());
            order.getAndIncrement();});
        normalHotPoint.forEach(hotPoint -> {System.out.println(order+" "+ hotPoint.show());
            order.getAndIncrement();});
        if(!(order.get() >1)){
            System.out.println("当前没有热搜。");
        }
    }

    /**
     * 添加热搜
     * @param hotPointName 热搜名称
     * @param superHotFlag 超级热搜标志
     */
    public void addHotPoint(String hotPointName, boolean superHotFlag) {
        normalHotPoint.add(new HotPoint(hotPointName, superHotFlag, hotID++));
    }

    /**
     * 为热搜投票
     * @param hotID 热搜ID
     * @return 投票结果
     */
    public boolean voteHotPoint(int hotID, int votes) {
        try {
            normalHotPoint.forEach(hotPoint -> {
                if (hotID == hotPoint.getHotPointID()) hotPoint.vote(votes);
            });
            moneyHotPoint.forEach(hotPoint -> {
                if (hotID == hotPoint.getHotPointID()) hotPoint.vote(votes);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 为热搜进行排序
     */
    private void hotPointListSort() {
        moneyHotPoint.sort(Comparator.comparingInt(HotPoint::getOrder));
        normalHotPoint.sort(Comparator.comparingInt(HotPoint::getHot).reversed());
    }

    /**
     * 买热搜，忽略多线程可能存在的问题
     * @param order 热搜排名
     * @param price 报价
     */
    public boolean buyHotPoint(int order, int price, int hotID){
        if(moneyHotPoint.size()<order){//购买的位号太靠后，自动提前（到购买的队尾）
            HotPoint hotPoint = getHotPointByHotID(hotID);
            hotPoint.setPrice(price);
            hotPoint.setOrder(moneyHotPoint.size()+1);
            moneyHotPoint.add(hotPoint);
            return true;
        }
        if (moneyHotPoint.get(order-1).getPrice()>= price) {
            System.out.println("当前报价过低");
            return false;
        }
        else{
            moneyHotPoint.remove(order-1);//替换该购买的热搜
            HotPoint hotPoint = getHotPointByHotID(hotID);
            hotPoint.setPrice(price);
            hotPoint.setOrder(order);
            moneyHotPoint.add(hotPoint);
        }
        return true;
    }

    /**
     * 在list中找到需要购买的热搜
     * @param hotID 热搜ID
     * @return 对应的热搜对象
     */
    private HotPoint getHotPointByHotID(int hotID) {
        Iterator<HotPoint> iterator = normalHotPoint.iterator();
        while(iterator.hasNext()){
            HotPoint hotPoint = iterator.next();
            if(hotPoint.getHotPointID() == hotID){
                iterator.remove();
                return hotPoint;
            }

        }
        iterator = moneyHotPoint.iterator();
        while(iterator.hasNext()){
            HotPoint hotPoint = iterator.next();
            if(hotPoint.getHotPointID() == hotID){
                iterator.remove();
                return hotPoint;
            }
        }
        throw new RuntimeException("No hotpoint with ID:"+hotID);
    }
}
