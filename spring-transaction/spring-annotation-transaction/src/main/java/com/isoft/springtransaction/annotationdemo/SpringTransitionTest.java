package com.isoft.springtransaction.annotationdemo;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransitionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	
	{
		ctx = new ClassPathXmlApplicationContext("config/transaction.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}

	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}

	@Test
	public void testBookShopDaoUpdateUserAccount() {
		bookShopDao.updateUserAccount("AA", 100);
	}

	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}

	@Test
	public void testTransactionPropagation() {
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}
}