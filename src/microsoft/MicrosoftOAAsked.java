package microsoft;

import java.util.HashMap;
import java.util.Map;

public class MicrosoftOAAsked {

    public static void main(String[] args) {

    }

    private String getEmailId(String S, String c) {
        S = S.toLowerCase().trim();
        c = c.trim().toLowerCase();
        String[] names = S.split(";");
        String domain = "@" + c + ".com";
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            String[] namePart = names[i].trim().split(" ");
            String firstName = namePart[0].trim().toLowerCase();
            String lastName = (namePart[namePart.length - 1]).replaceAll("-", "").trim().toLowerCase();
            lastName = lastName.substring(0, Math.min(lastName.length(), 8));
            String name = firstName + "." + lastName;
            int value = map.getOrDefault(name, 0);
            if (value > 0) {
                map.put(name, value + 1);
                name = name + value;
            } else {
                map.put(name, 2);
            }
            sb.append(name).append(domain);
            if (i != names.length - 1)
                sb.append("; ");
        }
        return sb.toString();
    }
}
