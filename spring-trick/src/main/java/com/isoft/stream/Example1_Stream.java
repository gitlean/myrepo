package com.isoft.stream;


import static com.isoft.stream.DataUtils.getTasks;

import java.util.List;
import java.util.stream.Collectors;



public class Example1_Stream {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        List<String> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())
                .map(Task::getTitle)//双冒号运算符
                .collect(Collectors.toList());

        readingTasks.forEach(System.out::println);
        
        /**
         *  代码构建了一个由许多流式操作组成的管道流，下面对其一一讲解
         *  stream(): 通过在一个原始的集合上调用stream方法来创建一个流式管道流，而tasks就是List<Task>类型的。
			filter(Predicate): 这个操作从流中    抽取  符合断言的判定条件的元素。一旦你有了一个数据流，你可以在其上不调用或者多次调用中间操作。lambda表达式task -> task.getType() == TaskType.READING定义了一个断言来过滤所有的阅读任务。  该lambda表达式的类型为java.util.function.Predicate<Task>。
			sorted(Comparator):这个操作返回一个根据由lambda表达式定义的比较器进行排序后的元素组成的数据流。在上面的例子中，这个比较器是(t1, t2) -> t1.getTitle().length() - t2.getTitle().length() 。
			map(Function
         */
    }
}
