package dao;

import java.lang.reflect.Field;
import java.util.ArrayList;

import annotation.Attribut;
import annotation.ForeignKey;
import annotation.Table;
import except.NoAttribut;
import except.NoMore;
import except.NoTable;

class Basic {

    static String getSql(Info info) {
        return null;
    }

    protected static Info info(Object object) throws NoTable, IllegalArgumentException, IllegalAccessException {
        return null;
    }

    protected static void verifTable(Table table) throws NoTable {
        if (table == null) {
            throw new NoTable();
        }
    }

    protected static void isRight(Info info, Class<?> cls) throws NoMore {
        if (info.getFieldval().size() == 0) {
            throw new NoMore(cls.getName());
        }
    }

    protected static ArrayList<String[]> explode(Class<?> cls, Object object)
            throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = cls.getDeclaredFields();
        ArrayList<String[]> fieldval = Basic.getFValue(fields, object);
        return fieldval;
    }

    protected static ArrayList<String[]> getFValue(Field[] fields, Object obj)
            throws IllegalArgumentException, IllegalAccessException {
        ArrayList<String[]> fieldval = new ArrayList<>();
        String[] ans = null;
        for (int i = 0; i < fields.length; i++) {
            try {
                ans = Basic.getFValue(fields[i], obj);
                fieldval.add(ans);
            } catch (NoAttribut e) {

            }
        }
        return fieldval;
    }

    protected static String[] 

    protected static String[] getFValue(Field field, Object obj)
            throws NoAttribut, IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);

        Attribut attribut = field.getAnnotation(Attribut.class);
        if (attribut == null) {
            throw new NoAttribut();
        }
        String[] ans = {
                Basic.extractAttribut(field, attribut),
                Basic.extractValue(field, obj, attribut)
        };
        return ans;
    }

    protected static String extractValue(Field field, Object obj, Attribut attribut)
            throws IllegalArgumentException, IllegalAccessException {
        String val = (String) field.get(obj).toString();
        if (attribut.varchar() && val != null) {
            String pathern = "'%s'";
            val = String.format(pathern, val);
        }
        return val;
    }

    protected static String extractAttribut(Field field, Attribut attribut) {
        String atName = field.getName();
        if (!attribut.value().equals("")) {
            atName = attribut.value();
        }
        return atName;
    }
}
