package test;

import java.util.Collections;
import java.util.List;

public class DbDataNode {
    private String Cod;
    private String Desc;
    private String Tp;
    private Integer Ci;
 
    private List<DbDataNode> children;
 
    public DbDataNode(String Cod, String Desc, String Tp, Integer Ci, List<DbDataNode> children) {
        this.Cod = Cod;
        this.Desc = Desc;
        this.Tp = Tp;
        this.Ci = Ci;
        this.children = children;
 
        if (this.children == null) {
            this.children = Collections.emptyList();
        }
    }
 
    public String getCod() {
        return Cod;
    }
 
    public String getDesc() {
        return Desc;
    }

    public String getTp() {
        return Tp;
    }
    
    public Integer getCi() {
        return Ci;
    }
 
    public List<DbDataNode> getChildren() {
        return children;
    }
 
    public void setChildren(List<DbDataNode> children) {
    	this.children = children;
}
    /**
     * Knotentext vom JTree.
     */
    public String toString() {
        return Cod;
    }
}
