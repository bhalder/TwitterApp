import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TweetDB {
   private HashMap<Integer, Tweet> DB;   
   private ReentrantLock bull; // Big User level lock

   public TweetDB() {
      DB = new HashMap<Integer, Tweet>();   
      bull = new ReentrantLock();
   }

   public void put(Integer tweetID, Tweet tweet) {
      bull.lock();

      try {
         DB.put(tweetID, tweet);
      } finally {
         bull.unlock();
      }
   }

   public Tweet get(Integer tweetID) {
      return DB.get(tweetID);
   }

}
