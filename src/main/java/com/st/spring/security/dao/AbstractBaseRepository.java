package com.st.spring.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractBaseRepository {

	@Autowired(required = true)
    protected NamedParameterJdbcTemplate jdbcTemplate;
}
