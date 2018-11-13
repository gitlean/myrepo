package com.isoft.enums.demo2;

//https://www.cnblogs.com/yysbolg/p/6554269.html
public enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量：枚举RED("红色", 1)括号中的属性来定义
    private String name;
    private int index;
    // 构造方法：传递所有的属性
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 1.通过编号得到名字
    public static String getNameByIndex(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // 2.通过编号得到枚举
    public static Color getColorByIndex(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return null;
    }
    // 3.通过名字得到编号
    public static int getIndexByName(String name) {
        for (Color c : Color.values()) {
            if (c.getName() == name) {
                return c.index;
            }
        }
        return -1;
    }
    // 通过名字得到枚举
    public static Color getColorByName(String name) {
        for (Color c : Color.values()) {
            if (c.getName() == name) {
                return c;
            }
        }
        return null;
    }
    
    
    //得到枚举的名字
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    //得到枚举的编号
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    
    // 覆盖方法：设置自定义枚举输出（一般不用）
//    @Override
//    public String toString() {
//        return this.index + "_" + this.name;
//    }
}
