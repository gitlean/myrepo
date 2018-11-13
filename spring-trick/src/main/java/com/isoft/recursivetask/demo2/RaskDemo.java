package com.isoft.recursivetask.demo2;

import java.util.concurrent.RecursiveAction;

/**
 * 下面以一个没有返回值的大任务为例，介绍一下RecursiveAction的用法。

	大任务是：打印0-100的数值。
	
	小任务是：每次只能打印20个数值。
 * @Author : Wukn
 * @Date : 2018/2/5
 */
public class RaskDemo extends RecursiveAction {
    /**
     *  每个"小任务"最多只打印20个数
      */
    private static final int MAX = 20;

    private int start;
    private int end;

    public RaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        //当end-start的值小于MAX时，开始打印
        if((end-start) < MAX) {
            for(int i= start; i<end;i++) {
                System.out.println(Thread.currentThread().getName()+"\ti的值"+i);
            }
        }else {
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            RaskDemo left = new RaskDemo(start, middle);
            RaskDemo right = new RaskDemo(middle, end);
            left.fork();
            right.fork();
        }
    }
}
