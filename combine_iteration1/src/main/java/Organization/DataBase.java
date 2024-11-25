package Organization;

import Department.Department;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private String url = "jdbc:mysql://localhost:3306/11.18?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private String user = "root";
    private String password = "1123581321a";

    public OrganizationNode buildOrganizationTree() {
        List<t_Organization> tOrganizations = getOrganizationsFromDatabase();
        List<t_user> tUsers = getUsersFromDatabase(tOrganizations);

        // 创建组织节点并构建树结构
        OrganizationNode root = null;
        List<OrganizationNode> organizationNodes = new ArrayList<>();
        for (t_Organization tOrg : tOrganizations) {
            OrganizationNode orgNode = new OrganizationNode(tOrg.getfID(), tOrg.getfName(), tOrg.getHigherUpfIDs(),
                    tOrg.getPermission(), tOrg.getRemark(), tOrg.getOrgGUID());
            organizationNodes.add(orgNode);
            if ("0".equals(tOrg.getHigherUpfIDs())) {
                root = orgNode;
            }
        }
        for (OrganizationNode orgNode : organizationNodes) {
            for (OrganizationNode childOrgNode : organizationNodes) {
                if (childOrgNode.getHigherUpId().equals(orgNode.getId())) {
                    orgNode.addChild(childOrgNode);
                }
            }
        }

        // 将用户添加到对应的组织节点下
        for (t_user tUser : tUsers) {
            for (OrganizationNode orgNode : organizationNodes) {
                if (tUser.getOrgIDs().contains(orgNode.getId())) {
                    orgNode.addChild(new UserNode(tUser.getfID(), tUser.getfName(), tUser.getOrgIDs(),
                            tUser.getUserGUID(), tUser.getPassword(), tUser.getRemark()));
                }
            }
        }

        return root;
    }

    public List<t_Organization> getOrganizationsFromDatabase() {
        List<t_Organization> tOrganizations = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection!= null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM t_Organization");
                while (resultSet.next()) {
                    String id = resultSet.getString("fID");
                    String name = resultSet.getString("fName");
                    String higherUpfIDs = resultSet.getString("fHigherUpfIDs");
                    String permission = resultSet.getString("fPermission");
                    String remark = resultSet.getString("fRemark");
                    String orgGUID = resultSet.getString("fOrgGUID");
                    t_Organization tOrganization = new t_Organization(id, name, higherUpfIDs, permission, remark, orgGUID);
                    tOrganizations.add(tOrganization);
                }
                statement.close();
                connection.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tOrganizations;
    }

    private List<t_user> getUsersFromDatabase(List<t_Organization> tOrganizations) {
        List<t_user> tUsers = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection!= null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM t_User");
                while (resultSet.next()) {
                    String id = resultSet.getString("fID");
                    String name = resultSet.getString("fName");
                    String orgIDs = resultSet.getString("fOrgIDs");
                    String userGUID = resultSet.getString("fUserGUID");
                    String password = resultSet.getString("fPassword");
                    String remark = resultSet.getString("fRemark");
                    t_user tuser = new t_user(id, name, orgIDs, userGUID, password, remark);
                    tUsers.add(tuser);
                }
                statement.close();
                connection.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tUsers;
    }
}