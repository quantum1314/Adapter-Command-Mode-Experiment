package Organization;

import Organization.T_node;

import java.util.ArrayList;
import java.util.List;

class t_user extends T_node {
    private String fID;
    private String fOrgIDs;
    private String fUserGUID;
    private String fPassword;

    public t_user(String fID, String fName, String fOrgIDs, String fUserGUID, String fPassword, String fRemark) {
        super(fName, fRemark);
        this.fID = fID;
        this.fOrgIDs = fOrgIDs;
        this.fUserGUID = fUserGUID;
        this.fPassword = fPassword;
    }

    @Override
    public void display() {
        System.out.println("t_User: " + fName + " fID: " + fID);
    }

    public String getOrgIDs() {
        return fOrgIDs;
    }

    public String getUserGUID() {
        return fUserGUID;
    }

    public String getPassword() {
        return fPassword;
    }

    public String getfName() {
        return fName;
    }
    public String getfID() {
        return fID;
    }
    public String getRemark() {
        return fRemark;
    }

    public List<String> getOrganizationPermissions(List<t_Organization> allTOrganizations) {
        List<String> permissions = new ArrayList<>();
        String[] orgIDArray = fOrgIDs.split("\\|");
        for (String orgID : orgIDArray) {
            for (t_Organization tOrganization : allTOrganizations) {
                if (tOrganization.getfID().equals(orgID)) {
                    String[] permissionArray = tOrganization.getPermission().split("\\|");
                    for (String permission : permissionArray) {
                        if (!permission.isEmpty()) {
                            permissions.add(permission);
                        }
                    }
                }
            }
        }
        return permissions;
    }
}