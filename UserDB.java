import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class UserDB {
   private HashMap<String, User> DB;   
   private ReentrantLock bull; // Big User Level Lock
   
   public UserDB() {
      DB = new HashMap<String, User>();   
      bull = new ReentrantLock();
   }

   public void put(String username, User user) {
      bull.lock();
      
      try {
         DB.put(username, user);
      } finally {
         bull.unlock();
      }
   }

   public User get(String username) {
      return DB.get(username);
   }

}
