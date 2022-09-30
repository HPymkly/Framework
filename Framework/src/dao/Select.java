package dao;

import java.util.ArrayList;

import annotation.Table;
import except.NoTable;
import tools.Tool;

class Select extends Basic {
    protected static String pathern = "SELECT %s FROM %s WHERE 1=1 %s";
    protected static String condform = " and %s %s %s";
    protected static String sepatator = ",";

    static String getCondition(Info info) {
        String condition = "";
        Object[] object = null;
        String signe = "=";
        for (int i = 0; i < info.getFieldval().size(); i++) {
            if (info.getFieldval().get(i)[1] != null) {
                object = new Object[] {
                        info.getFieldval().get(i)[0],
                        signe,
                        info.getFieldval().get(i)[1]
                };
                condition += String.format(Select.condform, object);
            }
        }
        return condition;
    }

    static String getSql(Info info) {
        String condition = Select.getCondition(info);
        String column = Tool.concat(info.getFieldval(), Select.sepatator)[0];
        Object[] object = {
                column,
                info.getTable().value(),
                condition
        };
        return String.format(Select.pathern, object);
    }

    public static Info info(Object object) throws NoTable, IllegalArgumentException, IllegalAccessException {
        Class<?> cls = object.getClass();
        Table table = cls.getAnnotation(Table.class);
        Basic.verifTable(table);
        ArrayList<String[]> fieldval = Save.explode(cls, object);
        Info info = new Info();
        info.setFieldval(fieldval);
        info.setObject(object);
        info.setTable(table);
        return info;
    }

    static Object[] find(Object object) throws NoTable, IllegalArgumentException, IllegalAccessException {
        Info info = Select.info(object);
        String sql = Select.getSql(info);
        System.out.println(sql);
        return null;
    }
}
