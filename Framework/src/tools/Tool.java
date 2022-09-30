package tools;

import java.util.ArrayList;

public class Tool {
    public static String[] concat(ArrayList<String[]> liste, String splt) {
        String[] answer = new String[liste.get(0).length];
        for (int i = 0; i < liste.size(); i++) {
            for (int j = 0; j < liste.get(i).length; j++) {
                if (i == 0) {
                    answer[j] = "";
                }
                answer[j] += ((i != 0) ? splt : "") + liste.get(i)[j];
            }
        }
        return answer;
    }
}
