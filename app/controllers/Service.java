package controllers;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
	
	public DataSource dataSource;
	Logger log = LoggerFactory.getLogger(this.getClass());

	public Service(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
