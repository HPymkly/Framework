package dao;

import java.util.ArrayList;
import tools.Tool;
import annotation.Table;
import except.NoMore;
import except.NoTable;

class Save extends Basic {
    protected static String pathern = "INSERT INTO %s%s values%s";
    protected static String sepatator = ",";

    static String getSql(Info info) {
        String tName = info.getObject().getClass().getName();
        if (!info.getTable().value().equals("")) {
            tName = info.getTable().value();
        }
        String[] liste = Tool.concat(info.getFieldval(), Save.sepatator);
        String column = liste[0];
        column = "(" + column + ")";
        String values = liste[1];
        values = "(" + values + ")";
        Object[] params = {
                tName,
                column,
                values
        };
        String ans = String.format(Save.pathern, params);
        return ans;
    }

    protected static Info info(Object object) throws NoTable, IllegalArgumentException, IllegalAccessException {
        Class<?> cls = object.getClass();
        Table table = cls.getAnnotation(Table.class);
        Save.verifTable(table);
        ArrayList<String[]> fieldval = Save.explode(cls, object);
        Info info = new Info();
        info.setTable(table);
        info.setFieldval(fieldval);
        info.setObject(object);
        return info;
    }

    static void save(Object object) throws NoTable, NoMore, IllegalArgumentException, IllegalAccessException {
        Class<?> cls = object.getClass();
        Info info = Save.info(object);
        Save.isRight(info, cls);
        String sql = Save.getSql(info);
        System.out.println(sql);
    }
}
