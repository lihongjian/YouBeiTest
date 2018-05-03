package json;

import java.util.List;

public class TableTestVo {

    String name;

    String type;

    TableFieldTestVo  key;

    List<TableFieldTestVo> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TableFieldTestVo getKey() {
        return key;
    }

    public void setKey(TableFieldTestVo key) {
        this.key = key;
    }

    public List<TableFieldTestVo> getFields() {
        return fields;
    }

    public void setFields(List<TableFieldTestVo> fields) {
        this.fields = fields;
    }
}
