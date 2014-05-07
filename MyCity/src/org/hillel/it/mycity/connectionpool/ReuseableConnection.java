package org.hillel.it.mycity.connectionpool;

import java.sql.Connection;

public interface ReuseableConnection extends Connection{
	boolean isAvailable();
}
