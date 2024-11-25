package Organization;

import Organization.T_node;
import Organization.t_user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class t_Organization extends T_node {
    private String fID;
    private String fPermission;
    private String fHigherUpfIDs;
    private String fOrgGUID;

    public t_Organization(String fID, String fName, String fHigherUpfIDs, String fPermission, String fRemark, String fOrgGUID) {
        super(fName, fRemark);
        this.fID = fID;
        this.fHigherUpfIDs = fHigherUpfIDs;
        this.fPermission = fPermission;
        this.fOrgGUID = fOrgGUID;
    }

    @Override
    public void display() {
        System.out.println("Organization.t_Organization: " + fName + " (fID: " + fID + ")");
        for (T_node tnode : ccomponents) {
            tnode.display();
        }
    }

    public String getfID() {
        return fID;
    }

    public String getfName() {
        return fName;
    }

    public String getHigherUpfIDs() {
        return fHigherUpfIDs;
    }

    public String getPermission() {
        return fPermission;
    }

    public String getRemark() {
        return fRemark;
    }

    public String getOrgGUID() {
        return fOrgGUID;
    }

    // 获取组织中所有用户的迭代器
    public Iterator<t_user> getUserIterator() {
        List<T_node> allTnodes = this.ccomponents;
        List<t_user> tusers = new ArrayList<>();
        for (T_node tnode : allTnodes) {
            if (tnode instanceof t_user) {
                tusers.add((t_user) tnode);
            }
        }
        return tusers.iterator();
    }
}