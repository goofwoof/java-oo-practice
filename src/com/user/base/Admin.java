package com.user.base;

import com.hotPoint.HotPointListInterface;
import com.scannerTool.ReadOption;

public class Admin extends User{

    public Admin(HotPointListInterface hotPointList) {
        super(hotPointList);
    }

    protected void createSuperHotPoint(String hotPointName){
        super.getHotPointList().addHotPoint(hotPointName, true);
    }

    public void adminMenu(){
        while(true){

            System.out.println("--------------------------欢迎您(管理员)--------------------------");
            System.out.println("-------------请选择需要的操作:");
            System.out.println("1.查看热搜排行 2.添加热搜 3.添加超级热搜 4.退出");
            try{
                int option = ReadOption.catOptionNumber(6);
                switch (option){
                    case 1:
                        this.seeHotPoint();
                        break;
                    case 2:
                        super.addMenu();
                        break;
                    case 3:
                        this.addSuperMenu();
                        break;
                    case 4:
                        System.out.println("结束当前普通用户服务.");
                        return;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void addSuperMenu() {
        System.out.println("请输入需要添加的超级热搜:");
        try {
            String hotPoint = ReadOption.catStr();
            this.createSuperHotPoint(hotPoint);
            System.out.println("超级热搜添加成功！");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
