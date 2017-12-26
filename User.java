import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

   private static int UserID = 0;

   private String username;
   private String password;
   private int userID;

   private ArrayList<User> followers;
   private ArrayList<User> following;
   private ArrayList<Tweet> tweets;

   public User(String username, String password) {
      this.username = username;
      this.password = password;

      this.followers = new ArrayList<User>();
      this.following = new ArrayList<User>();
      this.tweets = new ArrayList<Tweet>();
   
      this.userID = UserID;
      UserID++;
   }

   public String getPassword() {
      return password;
   }

   public int getUserId() {
      return this.userID;
   }

   public void follow(User follower) {
      if (follower != null) {
         followers.add(follower);
      }
   }

   public void unfollow(User follower) {
      if (follower != null) {
         followers.remove(follower);
      }
   }

   public List<User> getFollowers() {
      return followers;
   }

   public List<User> getFollowing() {
      return following;
   }

   public ArrayList<Tweet> getTweets() {
      return tweets;
   }

   public void addTweet(Tweet tweet) {
      if (tweet != null) {
         tweets.add(tweet);
      }
   }

   public String getUsername() {
      return username;
   }

}
