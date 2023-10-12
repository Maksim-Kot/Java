import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolFrequency {
    private String line;

    public SymbolFrequency(String line) {
        this.line = line;
    }

    public List<Character> Calculate (){
        HashMap<Character, Integer> freq = new HashMap<>();
        int number; char symbol;
        for(int i = 0; i < line.length(); i++) {
            symbol = line.charAt(i);
            if (!freq.containsKey(symbol)) {
                freq.put(symbol, 1);
            } else {
                number = freq.get(symbol);
                number++;
                freq.put(symbol, number);
            }
        }
        List<Character> a = new ArrayList<Character>();
        int max = 0;
        for (Map.Entry<Character, Integer> str: freq.entrySet()){
            if(str.getValue() == max) a.add(str.getKey());
            if(max < str.getValue()) {
                max = str.getValue();
                a.clear();
                a.add(str.getKey());
            }
        }
        return a;
    }
}
