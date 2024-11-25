package VisitorPattern;

import Department.*;
import Organization.UserNode;

import java.util.List;

// �г����ķ�����
public class MarketingDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // �г����ķ����߶��ڿ�������������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // �г����ķ����߶���ϵͳ����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // �г����ķ����߶�����ά����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        System.out.println("�������ƣ�" + department.getName());
        System.out.println("��Ա��");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("���ڼ��㣺ִ��8:30�򿨣��ڹ�˾�򿨣���Ҫʱ����Զ�̴򿨣���������ҵ�񣬲�����Ҫ�°�򿨡�");
        System.out.println("������㣺����ҵ�������㡣");
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // �г����ķ����߶��������칫�Ҳ�������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }
}