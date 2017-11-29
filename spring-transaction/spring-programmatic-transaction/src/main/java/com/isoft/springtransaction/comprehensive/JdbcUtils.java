package com.isoft.springtransaction.comprehensive;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcUtils {
	private static Logger logger=LoggerFactory.getLogger(JdbcUtils.class);
	private static String oracleDS = "dataSource";
	private static DataSource dataSource = null;

	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup(oracleDS);
		} catch (NamingException e) {
			logger.info("��������Դʧ�ܡ�����", e);
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			logger.info("��ȡ���ݿ�����ʧ�ܡ�����", e);
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("�ͷ����ݿ�����ʧ�ܡ�����", e);
			}
		}
	}

	public static void close(CallableStatement cs) {
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
				logger.info("�ر�CallableStatementʧ�ܡ�����", e);
			}
		}
	}

	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.info("�ر�PreparedStatementʧ�ܡ�����", e);
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.info("�ر�ResultSetʧ�ܡ�����", e);
			}
		}
	}

	public static void setAutoCommit(Connection conn, boolean autoCommit) {
		if (conn != null) {
			try {
				conn.setAutoCommit(autoCommit);
			} catch (SQLException e) {
				logger.info("���������ύ��ʽʧ�ܡ�����", e);
			}
		}
	}

	public static void commit(Connection conn) {
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				logger.info("�ύ����ʧ�ܡ�����", e);
			}
		}
	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				logger.info("�ع�����ʧ�ܡ�����", e);
			}
		}
	}

	public static void rollback(Connection conn, Savepoint sp) {
		if (conn != null) {
			try {
				conn.rollback(sp);
			} catch (SQLException e) {
				logger.info("�ع�����ʧ�ܡ�����", e);
			}
		}
	}

}