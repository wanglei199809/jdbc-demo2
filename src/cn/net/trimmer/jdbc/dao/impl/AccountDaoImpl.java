package cn.net.trimmer.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import cn.net.trimmer.jdbc.dao.AccountDao;
import cn.net.trimmer.jdbc.entity.Account;
import cn.net.trimmer.jdbc.util.JdbcUtils;

public class AccountDaoImpl implements AccountDao {

	@Override
	public boolean insertAccount(Account account) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean rs = false;
		try {
			conn = JdbcUtils.getConn();
			String sql = "insert into ACCOUNTS values(seq_account.nextval,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, account.getAccountName());
			pstm.setString(2, account.getPassword());
			pstm.setDouble(3, account.getBalance());
			pstm.setDate(4, new java.sql.Date(account.getOpenDate().getTime()));
			int i = pstm.executeUpdate();
			if (i > 0)
				rs = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(null, pstm, conn);
		}
		return rs;
	}

	@Override
	public boolean deleteAccountByAccountNo(String no) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean rs = false;
		try {
			conn = JdbcUtils.getConn();
			String sql = "delete from ACCOUNTS where accountno = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, no);
			int i = pstm.executeUpdate();
			if (i > 0)
				rs = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(null, pstm, conn);
		}
		return rs;
	}

	@Override
	public boolean updateAccount(Account account) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean rs = false;
		try {
			conn = JdbcUtils.getConn();
			String sql = "update ACCOUNTS set accountname = ?, password = ?, balance = ? ,  openDate = ? where accountno = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, account.getAccountName());
			pstm.setString(2, account.getPassword());
			pstm.setDouble(3, account.getBalance());
			pstm.setDate(4, new java.sql.Date(account.getOpenDate().getTime()));
			pstm.setString(5, account.getAccountNo());
			int i = pstm.executeUpdate();
			if (i > 0)
				rs = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(null, pstm, conn);
		}
		return rs;
	}

	@Override
	public Account selectOne(String no) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Account acc = null;
		try {
			conn = JdbcUtils.getConn();
			String sql = "select accountno,accountname,password,balance,opendate from ACCOUNTS where accountno = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, no);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String accountNo = rs.getString("accountno");
				String accountName = rs.getString("accountname");
				String password = rs.getString("password");
				Double balance = rs.getDouble("balance");
				Date openDate = rs.getDate("opendate");
				acc = new Account(accountNo, accountName, password, balance, openDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, pstm, conn);
		}
		return acc;
	}

}
