package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentilas from Database")
    public static List<String> getCredentials (String query) throws SQLException {
        List<String> list = new ArrayList<String>();
        rs= stmt.executeQuery(query);
        rs.next();
        list.add(rs.getString(1));
        list.add(rs.getString(2));
        return list;
    }





}
