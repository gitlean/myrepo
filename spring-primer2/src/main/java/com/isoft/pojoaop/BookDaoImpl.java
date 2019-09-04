package com.isoft.pojoaop;

public class BookDaoImpl implements IBookDao{

    public int add() {
        int a = 1/0;
        System.out.println("正在添加图书...");
        return 0;
    }

    public int delete() {
        System.out.println("正在删除图书...");
        return 0;
    }
}
