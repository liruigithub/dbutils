import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T, ID> extends AbstractDao<T, ID> {

    private Class<T> typeClass;
    private QueryRunner query;
    private Connection conn;

    protected BaseDao(){
        typeClass = (Class<T>) this.getTypeClass();
        query = new QueryRunner();
    }

    @Override
    public List<T> getAll() {
        conn = DbManager.getConnection();
        String sql = SqlUtil.getSelectAll(this.typeClass);
        try {
            List<T> list = query.execute(conn, sql, this.resultMapping());
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T getById(ID id) {
        conn = DbManager.getConnection();
        String sql = SqlUtil.getSelectById(this.typeClass);
        try {
            T one = query.query(conn, sql, new BeanHandler<>(this.typeClass), id);
            return one;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public boolean remove(ID id) {
        return false;
    }

    @Override
    public ResultSetHandler<T> resultMapping() {
        throw new RuntimeException("must override method resultMapping()");
    }

}
