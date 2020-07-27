package com.twu;

import com.hotPoint.HotPointListIml;
import com.hotPoint.HotPointListInterface;
import com.scannerTool.ReadOption;
import com.user.base.Admin;
import com.user.base.Normal;

public class Main {

    public static void main(String[] args) {
        HotPointListInterface hotPointList = new HotPointListIml();
        while(true){
            System.out.println("-------------Welcome to HotPoint!-------------");
            System.out.println("请选择身份或退出:");
            System.out.println("1.普通用户 2.管理员 3.退出");
            try{
                int option = ReadOption.catOptionNumber(4);
                switch (option){
                    case 1:
                        new Normal(hotPointList).normalMenu();
                        break;
                    case 2:
                        new Admin(hotPointList).adminMenu();
                        break;
                    case 3:
                        System.out.println("Wish see you again.");
                        return;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
