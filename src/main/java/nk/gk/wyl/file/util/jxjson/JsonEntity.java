package nk.gk.wyl.file.util.jxjson;

import java.util.List;

/**
 * json实体类
 */
public class JsonEntity {
    private String username;
    private String parent;
    private String label;
    List<JsonEntity> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<JsonEntity> getChildren() {
        return children;
    }

    public void setChildren(List<JsonEntity> children) {
        this.children = children;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
