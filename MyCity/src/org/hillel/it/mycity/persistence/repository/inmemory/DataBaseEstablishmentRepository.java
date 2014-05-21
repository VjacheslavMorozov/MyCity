package org.hillel.it.mycity.persistence.repository.inmemory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hillel.it.mycity.connectionpool.ConnectionPool;
import org.hillel.it.mycity.model.entity.BaseEntity;
import org.hillel.it.mycity.model.entity.Cinema;
import org.hillel.it.mycity.model.entity.Establishment;
import org.hillel.it.mycity.model.entity.NightClub;
import org.hillel.it.mycity.model.entity.Restaurant;
import org.hillel.it.mycity.persistence.repository.EstablishmentRepository;

public class DataBaseEstablishmentRepository extends InMemoryEstablishmentRepository implements EstablishmentRepository{
	private ConnectionPool cp;
	private List<Map<String, Integer>> cinemaIds;
	private List<Map<String, Integer>> restaurantIds;
	private List<Map<String, Integer>> nightClubIds;
	private String baseEntityGetId = null;
	private String establishmentGetId = null;
	
	public DataBaseEstablishmentRepository(ConnectionPool cp) {
		this.cp = cp;
		restaurantIds = new ArrayList<>();
		cinemaIds = new ArrayList<>();
		nightClubIds = new ArrayList<>();
		baseEntityGetId =  "SELECT MAX(idBaseEntity) FROM BaseEntity";
		establishmentGetId = "SELECT MAX(idEstablishment) FROM Establishment";
	}
	
	private void createDatabase() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = cp.getConnection();
			statement = conn.createStatement();
			String sqlDatabase = "CREATE DATABASE mycity";
			statement.executeUpdate(sqlDatabase);
		} catch (SQLException sqle) {
			if(sqle.getErrorCode() == 1007) {
				System.out.println("Database is alredy exist");
			} else {
				sqle.printStackTrace();
			}
		} finally {
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int getIdFromDataBase(String query) {
		String queryForId = query;
		int id = 0;
		try(Connection connection = cp.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery(queryForId);
				if(resultSet.next()) {
					id = resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	private void insertBaseEntityData() {
		String insertCreateBaseEntity = "INSERT INTO BaseEntity SET createdDate = NOW(), createdBy = 3";
		try(Connection connection = cp.getConnection()) {
			try(Statement baseEntityData = connection.createStatement()) {
				baseEntityData.executeUpdate(insertCreateBaseEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private <T extends Establishment>void insertEstablishmentData(T t) {
		String insertEstablishmentSQL = "INSERT INTO Establishment SET ";
		String basicEstablishmentSQLData = t.getEstablishmentSQLData();
		try(Connection connection = cp.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate(insertEstablishmentSQL + basicEstablishmentSQLData); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertCinemaData(Cinema cinema) {
		String insertCinemaSQL = "INSERT INTO Cinema SET ";
		String queryGetId = "SELECT MAX(idCinema) FROM Cinema";
		String cinemaSQLData = cinema.getCinemaSQLData();
		Map<String, Integer> cinemasMap = new HashMap<>();
		if(cinemaSQLData == "" && cinema.getEstablishmentSQLData() == "") {
			System.out.println("There is no data for DataBase");
			return;
		} else {
			insertBaseEntityData();
			insertEstablishmentData(cinema);
		}
		try(Connection connection = cp.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate(insertCinemaSQL + cinemaSQLData); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cinemasMap.put("BaseEntity", getIdFromDataBase(baseEntityGetId));
		cinemasMap.put("Establishment", getIdFromDataBase(establishmentGetId));
		cinemasMap.put("Cinema", getIdFromDataBase(queryGetId));
	}
	
	private void insertRestaurantData(Restaurant restaurant) {
		String insertRestaurantSQL = "INSERT INTO Restaurant SET ";
		String queryGetId = "SELECT MAX(idRestaurant) FROM Restaurant";
		String restaurantSQLData = restaurant.getRestaurantSQLData();
		Map<String, Integer> restaurantsMap = new HashMap<>();
		if(restaurantSQLData == "" && restaurant.getEstablishmentSQLData() == "") {
			System.out.println("There is no data for DataBase");
			return;
		} else {
			insertBaseEntityData();
			insertEstablishmentData(restaurant);
		}
		try(Connection connection = cp.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate(insertRestaurantSQL + restaurantSQLData); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		restaurantsMap.put("BaseEntity", getIdFromDataBase(baseEntityGetId));
		restaurantsMap.put("Establishment", getIdFromDataBase(establishmentGetId));
		restaurantsMap.put("Restaurant", getIdFromDataBase(queryGetId));
	}
	
	private void insertNightClubData(NightClub nightClub) {
		String insertNightClubSQL = "INSERT INTO NightClub SET ";
		String queryGetId = "SELECT MAX(idNightClub) FROM NightClub";
		String nightClubSQLData = nightClub.getNightClubSQLData();
		Map<String, Integer> nightClubsMap = new HashMap<>();
		if(nightClubSQLData == "" && nightClub.getEstablishmentSQLData() == "") {
			System.out.println("There is no data for DataBase");
			return;
		} else {
			insertBaseEntityData();
			insertEstablishmentData(nightClub);
		}
		try(Connection connection = cp.getConnection()) {
			try(Statement statement = connection.createStatement()) {
				statement.executeUpdate(insertNightClubSQL + insertNightClubSQL); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nightClubsMap.put("BaseEntity", getIdFromDataBase(baseEntityGetId));
		nightClubsMap.put("Establishment", getIdFromDataBase(establishmentGetId));
		nightClubsMap.put("NightClub", getIdFromDataBase(queryGetId));
	}
	
	private <T extends BaseEntity>void updateBaseEntity(T t, int id) {
		Date date = null;
		Connection connection = cp.getConnection();
		try(Statement statement = connection.createStatement()) {
			date = t.getModifiedDate();
			if(date != null) {
				String updateBaseEntity = "UPDATE BaseEntity SET modifiedDate = " + date + ", modifiedBy = 3 WHERE idBaseEntity = " + id;
				statement.executeUpdate(updateBaseEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private <T extends Establishment>void updateEstablishment(T t, int id) {
		String dataSQL = null;
		Connection connection = cp.getConnection();
		try(Statement statement = connection.createStatement()) {
			dataSQL = t.getEstablishmentSQLData();
			if(dataSQL != null) {
				String updateEstablishment = "UPDATE Establishment SET " + dataSQL + " WHERE idEstablishment = " + id;
				statement.executeUpdate(updateEstablishment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateCinema() {
		int count = 0;
		Connection connection = cp.getConnection();
		try(Statement statement = connection.createStatement()) {
			for(Cinema cinema : cinemas) {
				Map<String, Integer> tempMap = cinemaIds.get(count++);
				updateBaseEntity(cinema, tempMap.get("BaseEntity"));
				updateEstablishment(cinema, tempMap.get("Establishment"));
				String cinemaSQLData = cinema.getCinemaSQLData();
				String cinemaUpdateSQL = "UPDATE Cinema SET " + cinemaSQLData + " WHERE idCinema = " + tempMap.get("Cinema");
				statement.executeUpdate(cinemaUpdateSQL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void updateRestaurant() {
		int count = 0;
		Connection connection = cp.getConnection();
		try(Statement statement = connection.createStatement()) {
			for(Restaurant restaurant : restaurants) {
				Map<String, Integer> tempMap = restaurantIds.get(count++);
				updateBaseEntity(restaurant, tempMap.get("BaseEntity"));
				updateEstablishment(restaurant, tempMap.get("Establishment"));
				String restaurantSQLData = restaurant.getRestaurantSQLData();
				String restaurantUpdateSQL = "UPDATE Restaurant SET " + restaurantSQLData + " WHERE idRestaurant = " + tempMap.get("Restaurant");
				statement.executeUpdate(restaurantUpdateSQL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateNightClub() {
		int count = 0;
		Connection connection = cp.getConnection();
		try(Statement statement = connection.createStatement()) {
			for(NightClub nightClub : nightClubs) {
				Map<String, Integer> tempMap = nightClubIds.get(count++);
				updateBaseEntity(nightClub, tempMap.get("BaseEntity"));
				updateEstablishment(nightClub, tempMap.get("Establishment"));
				String nightClubSQLData = nightClub.getNightClubSQLData();
				String nightClubUpdateSQL = "UPDATE NightClub SET " + nightClubSQLData + " WHERE idNightClub = " + tempMap.get("NightClub");
				statement.executeUpdate(nightClubUpdateSQL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void flushCinema(Cinema cinema) {
		insertCinemaData(cinema);
	}
	
	@Override
	protected void flushRestaurant(Restaurant restaurant) {
		insertRestaurantData(restaurant);
	}
	
	@Override
	protected void flushNightClub(NightClub nightClub) {
		insertNightClubData(nightClub);
	}
	
	@Override
	public void updateDataBase() {
		updateCinema();
		updateNightClub();
		updateRestaurant();
	}
}
