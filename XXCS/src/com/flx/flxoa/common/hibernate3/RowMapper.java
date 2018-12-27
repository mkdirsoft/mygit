package com.flx.flxoa.common.hibernate3;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 刘凯
 * @date 2018-3-8 下午4:14:12
 * 描述：
 */
public interface RowMapper
{
    public Object mapRow(ResultSet rs, int index)
        throws SQLException;
}