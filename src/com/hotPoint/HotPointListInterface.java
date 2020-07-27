package com.hotPoint;

public interface HotPointListInterface {
    void addHotPoint(String hotPointName, boolean superHotFlag);
    void hotPointShow();
    boolean voteHotPoint(int hotID);
    boolean buyHotPoint(int order, int price, int hotID);
}
