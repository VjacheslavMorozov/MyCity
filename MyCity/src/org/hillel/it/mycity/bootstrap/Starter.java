package org.hillel.it.mycity.bootstrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hillel.it.mycity.connectionpool.ReuseableConnectionPool;
import org.hillel.it.mycity.info.Configuration;
import org.hillel.it.mycity.model.entity.Administrator;
import org.hillel.it.mycity.model.entity.Moderator;
import org.hillel.it.mycity.model.entity.User;
import org.hillel.it.mycity.persistence.repository.AssessmentRepository;
import org.hillel.it.mycity.persistence.repository.CommentRepository;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.UserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.FileUserRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryAssessmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryCommentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryEstablishmentRepository;
import org.hillel.it.mycity.persistence.repository.inmemory.InMemoryUserRepository;
import org.hillel.it.mycity.service.ServiceMyCity;
import org.hillel.it.mycity.service.impl.ServiceImpl;

public class Starter {
	public static void main(String[] args) {
		EstablishmentRepository inMemoryEstablishmentRepository = new InMemoryEstablishmentRepository();
		UserRepository inMemoryUserRepository = new FileUserRepository();
		CommentRepository inMemoryCommentRepository = new InMemoryCommentRepository();
		AssessmentRepository inMemoryAssessmentRepository = new InMemoryAssessmentRepository();
		
		ServiceMyCity serviceImpl = new ServiceImpl(inMemoryEstablishmentRepository, inMemoryUserRepository, inMemoryCommentRepository, inMemoryAssessmentRepository);
		
		Configuration configuration = Configuration.getInstance();
		
		ReuseableConnectionPool rcp = new ReuseableConnectionPool(configuration.getUrl(), configuration.getMaxConnCount());
		
		try(Connection conn = rcp.getConnection()) {
			try(Statement st = conn.createStatement()) {
//				st.executeUpdate("CREATE TABLE BaseEntity(" +
//						"baseentity_id INT GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
//						"createdDate DATE," +
//						"modifiedDate DATE," +
//						"createdBy_id INT," +
//						"modifiedBy_id INT," +
//						"PRIMARY KEY (baseentity_id)," +
//						"FOREIGN KEY (createdBy_id) REFERENCES Administrator(administrator_id)," +
//						"FOREIGN KEY (modifiedBy_id) REFERENCES Administrator(administrator_id))");
//				st.executeUpdate("CREATE TABLE Administrator(" + 
//						"administrator_id INT GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
//						"firstname VARCHAR(20)," +
//						"lastname VARCHAR(20)," +
//						"username VARCHAR(50)," +
//						"email VARCHAR(60)," +
//						"password VARCHAR(60)," +
//						"emailvarified BOOLEAN," +
//						"PRIMARY KEY (administrator_id))");
//				st.executeUpdate("DROP TABLE Administrator");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
