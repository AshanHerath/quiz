import database.DbConnect;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {
        DbConnect db = new DbConnect();
        Connection conn = db.getDBConnection();
    }
}
