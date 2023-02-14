package org.insta.application.app.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderHandler extends BaseTypeHandler<Gender> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Gender gender, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, gender.getDescription());
    }

    @Override
    public Gender getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return Gender.lookup(resultSet.getString(s));
    }

    @Override
    public Gender getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return Gender.valueOf(resultSet.getString(i));
    }

    @Override
    public Gender getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Gender.valueOf(callableStatement.getString(i));
    }
}
