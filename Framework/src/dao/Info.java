package dao;

import java.util.ArrayList;

import annotation.Table;

class Info {
    Object object;
    Table table;
    ArrayList<String[]> fieldval;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ArrayList<String[]> getFieldval() {
        return fieldval;
    }

    public void setFieldval(ArrayList<String[]> fieldval) {
        this.fieldval = fieldval;
    }

}
