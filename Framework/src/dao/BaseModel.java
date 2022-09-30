package dao;

import except.NoMore;
import except.NoTable;

public class BaseModel {
    public static void save(Object object) throws NoTable, NoMore, IllegalArgumentException, IllegalAccessException {
        Save.save(object);
    }

    public static Object[] find(Object object) throws NoTable, IllegalArgumentException, IllegalAccessException {
        Object[] answer = Select.find(object);
        return answer;
    }
}
