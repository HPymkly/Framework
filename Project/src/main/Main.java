package main;

import java.util.Date;

import dao.BaseModel;
import except.NoMore;
import except.NoTable;
import pers.Olona;

public class Main {

    public static void main(String[] args) throws NoTable, NoMore, IllegalArgumentException, IllegalAccessException {
        Olona olona = new Olona("Hasina", "Juniolah", 0, 5.95);
        olona.setDate(new Date());
        BaseModel.save(olona);
        BaseModel.find(olona);
    }
}
