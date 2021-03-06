import java.util.*;

public class RankCalculator
{
  public Map<Integer, Set<Integer>> calculateRank(Set<String> keys, Map<Integer, List<String>> reviewMap)
  {
    Map<Integer, Integer> idToRankMap = new HashMap<>();

    for (Map.Entry<Integer, List<String>> entry : reviewMap.entrySet())
    {
      Integer hotelId = entry.getKey();

      for (String review : entry.getValue())
      {
        String[] tokens = review.toLowerCase().split("[ \\.,!]");

        for (String token : tokens)
        {
          if (keys.contains(token))
          {
            Integer rank = idToRankMap.get(hotelId);

            if (rank == null)
            {
              rank = 0;
            }

            idToRankMap.put(hotelId, rank + 1);
          }
        }
      }
    }

    return sortByRank(idToRankMap);
  }

  private Map<Integer, Set<Integer>> sortByRank(Map<Integer, Integer> idToRankMap)
  {
    Map<Integer, Set<Integer>> rankToIdMap = new TreeMap<>();

    for (Integer id : idToRankMap.keySet())
    {
      Integer rank = idToRankMap.get(id);

      Set<Integer> ids = rankToIdMap.computeIfAbsent(rank, k -> new TreeSet<>());
      ids.add(id);
    }

    return rankToIdMap;
  }
}
