package com.st.spring.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.st.spring.security.model.LoginUser;

@Repository
public class UserDao extends AbstractBaseRepository {

	private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);
	
	private static final String USER_DETAILS_QUERY = "SELECT u.password from st_user u where u.principal=:USER_NAME";
	
	private static final String USER_ROLES_QUERY = " SELECT r.name FROM role r " + 
													" INNER JOIN user_roles ur ON r.id = ur.role_id " + 
													" INNER JOIN st_user u ON ur.user_id = u.id " + 
													" WHERE u.principal = :USER_NAME";
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public LoginUser getUserDetails(String userName) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("USER_NAME", userName);
		
		List<LoginUser> currentUser = jdbcTemplate.query(USER_DETAILS_QUERY, params, new RowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginUser currentUser = new LoginUser(userName, rs.getString("password"));
				return currentUser;
			}
		});
		
		LoginUser user = (currentUser != null && !currentUser.isEmpty()) ? currentUser.get(0) : null;
		
		if (user != null) {
			List<String> roles = jdbcTemplate.queryForList(USER_ROLES_QUERY, params, String.class);
			user.setRoles(roles);
			
			LOG.debug("User Details is {}, roles: {}", user.getUsername(), roles);
		}
		
		return user;
	}
	
	
	
	
	
	
}
