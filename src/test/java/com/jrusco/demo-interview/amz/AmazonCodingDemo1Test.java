import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

// Amazon customer reviews
public class AmazonCodingDemo1Test {
    
    @Test
    public void testChallenge(){
    }

    /*
     * What's the runtime complexity of this solution?
     * n lg(n) for the COllection.sort() call
     * O(n) for filtered repo and for loop
     */
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        
        String lowerCaseQuery = customerQuery.toLowerCase();
        List<String> filteredRepo = repository.stream()
            .map(String::toLowerCase)
            .filter(repoValue -> repoValue.startsWith(lowerCaseQuery.substring(0, 1)))
            .collect(Collectors.toList());
        Collections.sort(filteredRepo);
        List<List<String>> searchSuggestions = new LinkedList<>();


        for (int i = 2; i <= lowerCaseQuery.length(); i++) {
            String subQuery = lowerCaseQuery.substring(0, i);
            searchSuggestions.add(
                filteredRepo.stream()
                    .filter(repoValue -> repoValue.startsWith(subQuery))
                    .limit(3)
                    .collect(Collectors.toList())
            );
        }

        return searchSuggestions;
    }
}
