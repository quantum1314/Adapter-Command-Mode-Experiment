package Department;

import Organization.OrganizationNode;
import Organization.UserNode;
import VisitorPattern.DepartmentVisitor;

import java.util.List;

public abstract class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(DepartmentVisitor visitor, List<UserNode> users);
    public abstract List<UserNode> getUsers(OrganizationNode root);
}