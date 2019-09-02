import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MerchantAuthDaoImpl extends BaseDao<MerchantAuth, String> implements MerchantAuthDao {

    public MerchantAuthDaoImpl() {
        super();
    }

    @Override
    public ResultSetHandler<MerchantAuth> resultMapping() {
        return new ResultSetHandler<MerchantAuth>() {
            @Override
            public MerchantAuth handle(ResultSet resultSet) throws SQLException {
                if (!resultSet.next()) {
                    return null;
                }
                ResultSetMetaData meta = resultSet.getMetaData();
                MerchantAuth result = new MerchantAuth();
                result.setAuthId(resultSet.getString("auth_id"));
                result.setId(resultSet.getInt("id"));
                result.setParentId(resultSet.getString("parent_id"));
                return result;
            }
        };
    }
}
