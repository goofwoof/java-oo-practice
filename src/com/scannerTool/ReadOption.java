package com.scannerTool;

import java.util.Scanner;

public class ReadOption {
    static Scanner sc = new Scanner(System.in);

    /**
     * 读取一个操作数
     * @param MaxValue 0~MaxValue的操作允许范围
     * @return 操作数
     */
    public static int catOptionNumber(int MaxValue){
        if(!sc.hasNext()){
            throw new RuntimeException("Empty Option Error!");
        }
        int option = sc.nextInt();
        sc.nextLine();
        if(option<=0 ||option>=MaxValue){
            throw new RuntimeException("Wrong Option Error!");
        }
        return option;
    }

    /**
     * 读取一个操作热搜ID
     * @return 操作热搜ID
     */
    public static int catIDNumber() {
        if(!sc.hasNext()){
            throw new RuntimeException("Empty ID Error!");
        }
        int IDNumber = sc.nextInt();
        sc.nextLine();
        if(IDNumber<0){
            throw new RuntimeException("Wrong ID Error!");
        }
        return IDNumber;
    }

    /**
     * 读取一个热搜排名号1-》
     * @return 热搜排名号
     */
    public static int catOrderNumber() {
        if(!sc.hasNext()){
            throw new RuntimeException("Empty Order Error!");
        }
        int OrderNumber = sc.nextInt();
        sc.nextLine();
        if(OrderNumber<=0){
            throw new RuntimeException("Wrong Order Error!");
        }
        return OrderNumber;
    }

    /**
     * 读取一个字符串
     * @return 字符串
     */
    public static String catStr() {
        if(!sc.hasNext()){
            throw new RuntimeException("Empty Input Error!");
        }
        return sc.nextLine();
    }
}
