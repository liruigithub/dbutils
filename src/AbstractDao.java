import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T, ID> implements CrudDao<T, ID> {

    Class<?> getTypeClass(){
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    public abstract ResultSetHandler<T> resultMapping();

}
