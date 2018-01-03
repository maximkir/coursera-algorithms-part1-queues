import java.util.*;

public class Prefixes {

    public ArrayList<String> prefix(ArrayList<String> a) {
        Node root = new Node();
        for (String str : a){
            Node current = root;
            for (char c : str.toCharArray()){
                if (!current.nodes.containsKey(Character.valueOf(c))){
                    Node n = new Node();
                    current.nodes.put(Character.valueOf(c), n);
                }
                current = current.nodes.get(Character.valueOf(c));
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String str : a){
            Node current = root;

            String pref = "";
            for (char c : str.toCharArray()){
                pref+= c;
                current = current.nodes.get(Character.valueOf(c));
                if (current.nodes.size() <= 1){
                    answer.add(pref);
                    break;
                }

            }
        }

        return answer;
    }



    private static class Node {
        private Map<Character, Node> nodes = new HashMap<>();
    }


    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        input.add("zebra");
        input.add("dog");
        input.add("duck");
        input.add("dove");

        Prefixes prefixes = new Prefixes();

        for(String p : prefixes.prefix(input)){
            System.out.println(p);
        }

    }
}
