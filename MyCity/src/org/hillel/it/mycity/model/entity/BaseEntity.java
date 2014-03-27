package org.hillel.it.mycity.model.entity;

import java.util.Date;

public abstract class BaseEntity {
	protected static int id = 0;
	protected Date created;
	protected Date modified;
	protected Administrator createdBy;
	protected Administrator modifiedBy;
}
