package questions.medium.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();

    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }

    public void set(String key, String value, int timestamp) {
        List<Data> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Data(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        return binarySearch(map.get(key), timestamp);
    }

    public String binarySearch(List<Data> list, int timestamp) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp == timestamp)
                return list.get(mid).value;
            else if (list.get(mid).timestamp < timestamp) {
                if (mid < high && list.get(mid + 1).timestamp > timestamp)
                    return list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low >= list.size())
            low = list.size() - 1;
        return list.get(low).timestamp <= timestamp ? list.get(low).value : "";
    }

    static class Data {
        int timestamp;
        String value;

        Data(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

