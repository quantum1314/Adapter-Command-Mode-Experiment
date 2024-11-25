package VisitorPattern;

import Department.*;
import Organization.UserNode;

import java.util.List;

// �з�������������������
public class DevelopmentDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        System.out.println("�������ƣ�" + department.getName());
        System.out.println("��Ա��");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("���ڼ��㣺ִ�е����ϰ�ʱ�䣬�����ϰ�ʱ����°�ʱ�䣬ÿ�����°�򿨣�ÿ�칤����8Сʱ���ɡ�");
        System.out.println("������㣺�����ύ�Ĵ����������������㡣");
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // �����������߶���ϵͳ����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // �����������߶�����ά����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // �����������߶����г�����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // �����������߶��������칫�Ҳ�������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }
}


