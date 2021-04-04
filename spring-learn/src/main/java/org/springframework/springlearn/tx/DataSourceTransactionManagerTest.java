package org.springframework.springlearn.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务
 *
 * @author ZhengYu
 * @version 1.0 2021/4/4 14:04
 **/
public class DataSourceTransactionManagerTest {
	public static void main(String[] args) {
		// 初始化事务同步缓存回调
		TransactionSynchronizationManager.initSynchronization();
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {

		});

		// 创建一个数据源
		DataSource dataSource = buildDataSource();

		// 创建 DataSourceTransactionManager
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);

		// 开启事务
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
		// 执行SQL
		if (connectionHolder != null) {
			doSqlExec(connectionHolder.getConnection());
		}

		// 提交事务
		transactionManager.commit(transactionStatus);
	}

	private static DataSource buildDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://192.168.9.102:12003/db1?&useSSL=false&characterEncoding=utf8");
		druidDataSource.setUsername("java");
		druidDataSource.setPassword("R$dXWU6ZMOG*wiQ9");
		druidDataSource.setInitialSize(10);
		druidDataSource.setMinIdle(5);
		druidDataSource.setMaxActive(10);
		druidDataSource.setMaxWait(60000);
		druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
		druidDataSource.setMinEvictableIdleTimeMillis(300000);
		druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTestOnBorrow(true);
		druidDataSource.setTestOnReturn(false);
		druidDataSource.setPoolPreparedStatements(true);
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		return druidDataSource;
	}

	private static void doSqlExec(Connection connection) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into t_user (name) values ('zy')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
