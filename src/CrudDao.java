import java.util.List;

public interface CrudDao<T,ID> {

    List<T> getAll();

    T getById(ID id);

    T save(T t);

    T update(T t);

    boolean remove(ID id);

}
