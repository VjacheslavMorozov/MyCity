package org.hillel.it.mycity.connectionpool;

import java.sql.Connection;

public interface ConnectionPool {
	Connection getConnection();
	void destroy();
}
