package VisitorPattern;
import Department.*;
import Organization.UserNode;

import java.util.List;

public interface DepartmentVisitor {
    void visit(DevelopmentDepartment department,List<UserNode> users);
    void visit(SystemDepartment department,List<UserNode> users);
    void visit(OperationsDepartment department,List<UserNode> users);
    void visit(MarketingDepartment department,List<UserNode> users);
    void visit(AdministrativeOffice department,List<UserNode> users);



}