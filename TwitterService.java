import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class TwitterService {
   
   private static UserDB userDB = new UserDB();
   private static TweetDB tweetDB = new TweetDB();

   private User currentUser;

   public TwitterService() {
      currentUser = null;
   }

   public void listTweets() {
      int count = 0;

      if (currentUser == null) {
         System.out.println("You are not logged in.");
         return;
      }

      for (Tweet tweet : currentUser.getTweets()) {
         System.out.println("== " + tweet.getContent());
         count++;

         if (count == 10) {
            return;
         }
      }
   }

   public void createUser(String username, String password) {
      if (userDB.get(username) != null) {
         System.out.println("The user already exists\n");
         return;
      }

      User newUser = new User(username, password);
      userDB.put(username, newUser);
   }

   public void login(String username, String password) {
      if (userDB.get(username) == null) {
         System.out.println("The user does not exist.");
         return;
      }

      currentUser = userDB.get(username);
      if(currentUser.getPassword() != password) {
         System.out.println("Invalid password!");
         currentUser = null;
         return;
      }
   }

   public void logout() {
      currentUser = null;
   }

   public void tweet(String content) {
      if (currentUser != null) {
         Tweet tw = new Tweet(currentUser, content);
         currentUser.addTweet(tw);
         tweetDB.put(tw.getId(), tw);
      } else {
         System.out.println("You are not logged in. You cannot tweet.");
      }
   }

   public void listFollowers() {
      if (currentUser != null) {
         List<User> userList =  currentUser.getFollowers();

         for(User user : userList) {
            System.out.println("User : " + user.getUsername());
         }

      } else {
         System.out.println("You are not logged in.");
      }
   }

   public List<User> getFollowers() {
      if (currentUser != null) {
         return currentUser.getFollowers(); 
      } else {
         System.out.println("You are not logged in.");
         return null;
      }
   }

   public List<User> getFollowing() {
      if (currentUser != null) {
         return currentUser.getFollowing();
      } else {
         System.out.println("You are not logged in.");
         return null;
      }
   }

   public void follow(String username) {
      if (currentUser != null) {
         User user = userDB.get(username);
         if (user == null) {
            System.out.println("The user does not exist");
            return;
         }

         currentUser.follow(user);
      } else {
         System.out.println("You are not logged in.");
      }
   }

   public void unfollow(String username) {
      if (currentUser != null) {
         User user = userDB.get(username);
         if (user == null) {
            System.out.println("The user does not exist");
            return;
         }

         currentUser.unfollow(user);
      } else {
         System.out.println("You are not logged in.");
      }
   }

}
