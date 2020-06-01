package cn.net.trimmer.jdbc.test;

import java.util.Date;

import org.junit.Test;

import cn.net.trimmer.jdbc.dao.AccountDao;
import cn.net.trimmer.jdbc.dao.impl.AccountDaoImpl;
import cn.net.trimmer.jdbc.entity.Account;

/**
 * 测试增删改查的方法
 * 
 * @author wl
 *
 */
public class TestAccountDao {	
	static final AccountDao dao = new AccountDaoImpl();

	@Test
	public void testUpdateAccount() {
		Account account = new Account("61", "蘑菇头老爸", "100000", 8000.0, new Date());
		boolean b = dao.updateAccount(account);
		if(b) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}

	@Test
	public void testDeleteAccountByNo() {
		boolean b = dao.deleteAccountByAccountNo("42");
		if(b) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testInsert() {
		Account account = new Account("", "蘑菇头", "123456", 3000.0, new Date());
		boolean b = dao.insertAccount(account);
		if(b) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
	}
	
	@Test
	public void testSelectOne() {
		Account account = dao.selectOne("43");
		System.out.println(account);
	}
}
