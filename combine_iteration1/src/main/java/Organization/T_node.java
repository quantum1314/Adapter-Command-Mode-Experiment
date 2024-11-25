package Organization;

import java.util.ArrayList;
import java.util.List;

abstract class T_node {
    protected String fName;
    protected String fRemark;
    protected List<T_node> ccomponents;

    public T_node(String fName, String fRemark) {
        this.fName = fName;
        this.fRemark = fRemark;
        this.ccomponents = new ArrayList<>();
    }

    public void add(T_node tnode) {
        ccomponents.add(tnode);
    }

    public void delete(T_node tnode) {
        ccomponents.remove(tnode);
    }

    public abstract void display();
}