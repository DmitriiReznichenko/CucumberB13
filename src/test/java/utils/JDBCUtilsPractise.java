package utils;

import java.util.List;
import java.util.Map;

public class JDBCUtilsPractise {

    public static void main(String[] args) {
        JDBCUtils.establishCondition();
        List<Map<String,Object>> region=JDBCUtils.executeQuery("select * from regions");
        System.out.println(region.get(2).get("REGION_NAME"));
        JDBCUtils.closeConnection();
    }
}
