package com.isoft.springtransaction.annotationjt;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
public class StudentService {

	@Autowired
	private StudentDao dao;

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.NESTED, timeout = 1000, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, noRollbackFor = CustomRuntimeException.class)
	public void doComplexLogic() {

		// select
		List<Student> list = dao.getAllStudent();
		for (Student student : list) {
			System.out.println(student);
		}

		// update
		Student student = list.get(0);
		student.setName("zhejiang");
		dao.updateStudent(student);
		System.out.println("did update temporarily...");

		//int a = 9 / 0; 
		// 遇到异常，整个事务回滚
		// 如果try catch捕获这个异常，那整个事务会顺利执行，不会回滚  (doComplexLogic()抛出Exception才会rollback)

		int b = 2;
		if (b > 1) {
			throw new CustomRuntimeException();
			// 事务不会回滚，也就是上面的update操作会提交  （注意@Transactional上的noRollbackFor）
		}

		// insert
		student = new Student();
		student.setName("hello");
		student.setBirth(new Date(354778));
		student.setScore(78.9f);
		dao.insertStudent(student);
		System.out.println("did insert...");

		// delete
		// dao.deleteStudent(3);
		// System.out.println("did delete...");

	}

	class CustomRuntimeException extends RuntimeException {
		public CustomRuntimeException() {
			super();
		}

		public CustomRuntimeException(String msg) {
			super(msg);
		}
	}
}
