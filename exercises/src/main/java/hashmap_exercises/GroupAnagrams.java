package hashmap_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49 - Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * <p>
 * Example:
 * Input: ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    private boolean add;

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: implement
        // Typical approach:
        // - For each string, sort its characters to get a "canonical form"
        // - Use a Map<String, List<String>>: canonicalForm -> list of words
        // - Return the map's values as the result
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);
            List<String> words;
            if (map.containsKey(key)) {
                words = map.get(key);
            } else {
                words = new ArrayList<>();
            }
            words.add(str);
            map.put(key, words);
        }
        return new ArrayList<>(map.values());
    }
}
