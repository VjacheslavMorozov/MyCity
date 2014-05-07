package org.hillel.it.mycity.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReuseableConnectionPool implements ConnectionPool, AutoCloseable{
	private String url;
	private List<ReuseableConnection> conns;
	private int maxConnCount;
	
	public ReuseableConnectionPool(String url, int maxConnCount) {
		this.url = Objects.requireNonNull(url);
		if(maxConnCount < 0) {
			throw new RuntimeException();
		}
		this.maxConnCount = maxConnCount;
		conns = new ArrayList<>(maxConnCount);
	}
	
	private ReuseableConnection createConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url);
		ReuseableConnection rc = new ReuseableConnectionImpl(conn);
		conns.add(rc);
		return rc;
	}
	
	@Override
	public Connection getConnection() {
		for(ReuseableConnection rc : conns) {
			if(rc.isAvailable()) {
				return rc;
			}
		}
		if(conns.size() < maxConnCount) {
			try {
				return createConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void close() throws Exception {}

	@Override
	public void destroy() {
		for(ReuseableConnection rc : conns) {
			if(!rc.isAvailable()) {
				try {
					rc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		conns.clear();
	}
}
