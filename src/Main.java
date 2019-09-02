import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DbManager.init("jdbc:mysql://localhost:3306/janus_sell", "root", "root");
        MerchantAuthDao merchantAuthDao = new MerchantAuthDaoImpl();
        List<MerchantAuth> list = merchantAuthDao.getAll();
        System.out.println(list);
    }
}
