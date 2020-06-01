package cn.net.trimmer.jdbc.dao;

import cn.net.trimmer.jdbc.entity.Account;

public interface AccountDao {
	//增
	boolean insertAccount(Account account);
	//删
	boolean deleteAccountByAccountNo(String no);
	//改
	boolean updateAccount(Account account);
	//查
	Account selectOne(String no);	
}
