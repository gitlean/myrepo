package com.isoft.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Java8允许你在集合对象上调用stream方法来创建一个Stream。Stream支持数据处理操作，所以开发者可以用高层数据处理结构来表示计算过程。
 * 
 * @author john
 * @date 2018年10月27日
 * @time 下午4:35:29
 * @describe:
 */
public class TestMain {

	public static void main(String[] args) {

		/*
		// Supplier<String> uuids = () -> UUID.randomUUID().toString();
		Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());

		uuidStream.forEach(System.out::println);
		*/
		
		
		
		//为了创建一个范围的值，我们可以使用range方法，它能创建一个从0开始到9的数据流，它不包括10。
		IntStream.range(0, 10).forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		
		//rangeClosed方法允许你创建包含右边界的数据流。所以下面的数据流将从1开始，到10结束。

		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		System.out.println("-----------------------------------");
		
		//你也可以像下面这样通过iterate方法在原始数据流上创建一个无限的数据流。

		LongStream infiniteStream = LongStream.iterate(1, el -> el + 1);
		//infiniteStream.forEach(System.out::println);
		
		//为过滤掉无限数据流中所有的偶数，我们可以编写如下的代码。

		infiniteStream.filter(el -> el % 2 == 0).forEach(System.out::println);
		
		//我们可以像下面这样通过使用limit操作来限制结果数据流的数量。

		infiniteStream.filter(el -> el % 2 == 0).limit(100).forEach(System.out::println);
		
		
		
		
	}

	/**
	 * 例子1：找到所有的阅读任务并按照它们的创建日期排序
	 * 我们讨论的第一个例子是找到所有的阅读任务，并按照它们的创建日期进行排序。我们需要执行的操作如下：
	 * 
	 * 过滤所有的任务来找到任务类型为READING的任务。 
	 * 将过滤后的结果按照createdOn域进行排序。 
	 * 获得每个任务的标题。
	 * 将结果的标题收集到一个列表中。 
	 * 
	 * 上面的四个操作可以被容易地转换为如下的代码。
	 * 
	 * @param tasks
	 * @return
	 */
	private static List<String> allReadingTasks(List<Task> tasks) {
		List<String> readingTaskTitles = tasks.stream()
				.filter(task -> task.getType() == TaskType.READING)
				.sorted((t1, t2) -> t1.getCreatedOn().compareTo(t2.getCreatedOn()))
				.map(task -> task.getTitle())
				.collect(Collectors.toList());
		return readingTaskTitles;
	}
	
	//我们可以像下面一样通过使用Comparator接口的comparing方法和方法引用来优化上面的Java8代码。
	public List<String> allReadingTasks2(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            sorted(Comparator.comparing(Task::getCreatedOn)).
	            map(Task::getTitle).
	            collect(Collectors.toList());

	}
	
	
	//通过使用复合函数，我们可以轻易地通过在比较器上调用reversed方法来编写将元素反向排序的代码。
	public List<String> allReadingTasksSortedByCreatedOnDesc(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            sorted(Comparator.comparing(Task::getCreatedOn).reversed()).
	            map(Task::getTitle).
	            collect(Collectors.toList());
	}
	
	
	/**
	 * 例子2：找到唯一的任务
	 * 假设我们的数据集中有重复的任务。如下所示，我们可以在数据流上使用distinct方法来轻易地去除重复元素从而得到唯一的元素。
	 * distinct方法将一个数据流转化成另一个没有重复元素的数据流。它使用对象的equals方法来决定对象是否相等。根据对象equals方法的约定，当两个对象相等的时候，它们被认为是重复的，然后其中一个会从结果数据流中被移除。
	 * 
	 * @param tasks
	 * @return
	 */
	
	public List<Task> allDistinctTasks(List<Task> tasks) {
	    return tasks.stream().distinct().collect(Collectors.toList());
	}
	
	/**
	 * 例子4：计算所有阅读任务的数量 为了得到所有阅读任务的数量，我们可以在数据流上使用count方法。这个方法是一个结束操作。
	 * 
	 * @param tasks
	 * @return
	 */
	public long countAllReadingTasks(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            count();
	}
	
	/**
	 * 例子5：从所有的任务中找出所有不同的标签 为了找出所有不同的标签，我们需要进行如下的操作：
	 * 
	 * 为每一个任务提取标签。 将所有的标签收集进一个数据流。 将重复的标签除去。 最后将收集的结果放入一个列表。
	 * 第一个和第二个操作可以通过在tasks数据流上使用flatMap操作来完成。flatMap操作将每次调用tasks.getTags().stream()产生的数据流合并到一个中。一旦我们将所有标签放入一个数据流中，我们可以仅仅通过distinct方法来获取所有不同的标签。
	 * 
	 * @param tasks
	 * @return
	 */
	private static List<String> allDistinctTags(List<Task> tasks) {
        return tasks.stream().flatMap(task -> task.getTags().stream()).distinct().collect(Collectors.toList());
	}
	
	
	/**
	 * 例子6：检查是否所有的阅读任务都有books标签 Stream
	 * API提供了方法让用户来检查数据集中元素的某一属性是否符合要求。这些方法是allMatch、anyMatch、findFirst和findAny。为了检查是否所有的阅读任务都一个名叫books的标签，我们可以编写如下的代码。
	 * 
	 * @param tasks
	 * @return
	 */
	public boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            allMatch(task -> task.getTags().contains("books"));
	}
	
	
	//为了检查是否有阅读任务有java8标签，我们可以像下面这样使用anyMatch操作。
	public boolean isAnyReadingTasksWithTagJava8(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            anyMatch(task -> task.getTags().contains("java8"));
	}
	
	
	
	/**
	 * 例子7：创建一个所有标题的总结
	 * 假设你想创建一个所有标题的总结。使用reduce操作，它将数据流缩减为一个值。reduce方法以将数据流中元素进行连接的lambda表达式为参数。
	 * 
	 * @param tasks
	 * @return
	 */
	public String joinAllTaskTitles(List<Task> tasks) {
	    return tasks.stream().
	            map(Task::getTitle).
	            reduce((first, second) -> first + " *** " + second).
	            get();
	}
	
	public void demo9(){
		//如下所示，你可以通过使用Arrays类的静态方法stream来从数组创建数据流。
		String[] tags = {"java", "git", "lambdas", "machine-learning"};
		Arrays.stream(tags).map(String::toUpperCase).forEach(System.out::println);
		
		
		//你也可像下面这样从一个数组特定的起始下标到结束下标来创建一个数据流。在这里，起始下标被包含在内，而结束下标没有。
		Arrays.stream(tags, 1, 3).map(String::toUpperCase).forEach(System.out::println);
	}
	
}
