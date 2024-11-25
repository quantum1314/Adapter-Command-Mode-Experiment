package Organization;


import Organization.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UserNode implements TreeNode {
    private String id;
    private String orgIds;
    private String userGUID;
    private String name;
    private String password;
    private String remark;

    public UserNode(String id, String name, String orgIds, String userGUID, String password, String remark) {
        this.id = id;
        this.name = name;
        this.orgIds = orgIds;
        this.userGUID = userGUID;
        this.password = password;
        this.remark = remark;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<TreeNode> getChildren() {
        return null;
    }

    @Override
    public void display(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append(name).append(" (").append(id).append(")");
        System.out.println(sb.toString());
    }

    public String getOrgIds() {
        return orgIds;
    }

    public String getUserGUID() {
        return userGUID;
    }

    public String getPassword() {
        return password;
    }

    public String getRemark() {
        return remark;
    }

    public void displayPermissions(List<t_Organization> allTOrganizations) {
        List<String> permissions = getOrganizationPermissions(allTOrganizations);
        System.out.println("UserGUID " + name + ": " + userGUID);
        System.out.println("Power " + name + ": " + permissions);
    }

    public List<String> getOrganizationPermissions(List<t_Organization> allTOrganizations) {
        List<String> permissions = new ArrayList<>();
        String[] orgIDArray = orgIds.split("\\|");
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