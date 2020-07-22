package com.user.base;

import com.scannerTool.ReadOption;
import com.hotPoint.HotPointList;

public class Normal extends User{
    private int restVote = 10;
    public Normal(HotPointList hotPointList) {
        super(hotPointList);
    }

    protected boolean vote(int hotID) {
        if(super.getHotPointList().voteHotPoint(hotID)){
            restVote--;
            return true;
        }
        else return false;
    }

    protected boolean buyHotPoint(int hotID, int price, int order){
        return super.getHotPointList().buyHotPoint(order, price, hotID);
    }


    public void normalMenu(){
        while(true){
            System.out.println("--------------------------欢迎您(普通用户)--------------------------");
            System.out.println("-------------请选择需要的操作:");
            System.out.println("1.查看热搜排行 2.为热搜投票 3.添加热搜 4.购买热搜 5.退出");
            try{
                int option = ReadOption.catOptionNumber(6);
                switch (option){
                    case 1:
                        this.seeHotPoint();
                        break;
                    case 2:
                        System.out.println("您当前剩余票数为:"+this.restVote);
                        if(this.restVote>0)
                            this.voteMenu();
                        break;
                    case 3:
                        super.addMenu();
                        break;
                    case 4:
                        this.buyMenu();
                        break;
                    case 5:
                        System.out.println("结束当前普通用户服务.");
                        return;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    private void buyMenu() {
        System.out.println("请输入需要购买的热搜的ID号:");
        this.seeHotPoint();
        try {
            int IDNumber = ReadOption.catIDNumber();
            System.out.println("请输入需要购买的热搜排名:");
            int order = ReadOption.catIDNumber();
            System.out.println("请输入您的报价:");
            int price = ReadOption.catIDNumber();
            if (this.buyHotPoint(IDNumber, price, order)) {
                System.out.println("购买成功！");
            } else System.out.println("购买失败。");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected void voteMenu(){
        System.out.println("请输入需要投票的热搜的ID号:");
        this.seeHotPoint();
        try {
            int IDNumber = ReadOption.catIDNumber();
            if (this.vote(IDNumber)) {
                System.out.println("投票成功！");
            } else System.out.println("投票失败。");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
