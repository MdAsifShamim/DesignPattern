package com.spring.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.springframework.util.StringUtils;

public class DBUtils8 {

	public static Consumer<Statement> closeStatement = ps -> {
		try {
			if (!StringUtils.isEmpty(ps)) {
				ps.close();
			}
		} catch (Exception e) {
			e.getCause().getMessage();
		}

	};

	public static Consumer<ResultSet> closeResultSet = rs -> {
		try {
			if (!StringUtils.isEmpty(rs)) {
				rs.close();
			}
		} catch (Exception e) {
			e.getCause().getMessage();
		}

	};

	public static BiConsumer<Statement, ResultSet> closeStatment_ResultSet = (ps, rs) -> {
		try {
			if (!StringUtils.isEmpty(rs)) {
				rs.close();
			}

			if (!StringUtils.isEmpty(ps)) {
				ps.close();
			}
		} catch (Exception e) {
			e.getCause().getMessage();
		}
	};

	public static Consumer<Connection> closeConnection = connection -> {
		try {
			if (!StringUtils.isEmpty(connection)) {
				connection.close();
			}
		} catch (Exception e) {
			e.getCause().getMessage();
		}

	};

}
