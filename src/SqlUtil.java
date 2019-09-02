import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SqlUtil {

    private SqlUtil(){}

    public static List<String> getColumnNames(Class<?> entityClass){
        return resolveEntityFields(entityClass);
    }

    static String getColumnFromAnnotation(Field field){
        if (field == null) {
            return null;
        }
        Column annotation = field.getAnnotation(Column.class);
        if (annotation == null) {
            return null;
        }
        return annotation.name();
    }

    public static List<String> resolveEntityFields(Class<?> entityClass){
        Field[] fields = entityClass.getDeclaredFields();
        List<String> columns = new ArrayList<>();
        String column = null;
        for (Field field : fields) {
            field.setAccessible(true);
            column = getColumnFromAnnotation(field);
            if (column == null) {
                continue;
            }
            columns.add(column);
        }
        return columns;
    }

    public static String resolveEntityId(Class<?> entityClass){
        Field[] fields = entityClass.getDeclaredFields();
        String id = null;
        String column = null;
        for (Field field : fields) {
            field.setAccessible(true);
            Column annotation = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            if (annotation.pk()) {
                id = annotation.name();
                break;
            }
        }
        if (null == id) {
            throw new RuntimeException("id column not found.");
        }
        return id;
    }

    public static String getSelectAll(Class<?> clazz){
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        List<String> columns = getColumnNames(clazz);
        for (int i = 0; i < columns.size(); i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(columns.get(i));
        }
        String tableName = getTableName(clazz);
        stringBuilder.append(" FROM " + tableName + " WHERE 1=1 ");
        return stringBuilder.toString();
    }

    public static String getSelectById(Class<?> clazz){
        String sql = getSelectAll(clazz);
        String idColumn = resolveEntityId(clazz);
        return sql + " AND " + idColumn + " = ?";
    }

    static String getTableName(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        return table.name();
    }

    public static void main(String[] args) {
        List<String> columns = SqlUtil.getColumnNames(MerchantAuth.class);
        String selectAll = SqlUtil.getSelectAll(MerchantAuth.class);
        System.out.println(columns);
        System.out.println(selectAll);
    }

}
