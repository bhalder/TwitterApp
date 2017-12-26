import java.util.ArrayList;

public class Tweet {
   private static int IDstore = 0;

   private String content;
   private User user;
   private int likes;
   private int retweets;
   private int tweetID;
   private ArrayList<Integer> retweeters;

   public Tweet(User user, String content) {
      this.user = user;
      this.content = content;

      this.likes = 0;
      this.retweets = 0;
      this.tweetID = IDstore;
      this.retweeters = new ArrayList<Integer>();
      
      IDstore++;
   } 

   public int getId() {
      return this.tweetID;
   }

   public void likeTweet() {
      likes++;
   }

   public void dislikeTweet() {
      if (likes > 0) {
         likes--;
      }
   }

   public int getLikes() {
      return likes;
   }

   public int getRetweets() {
      return retweets;
   }

   public void retweet(int userID) {
      retweeters.add(userID);
   }

   public String getContent() {
      return content;
   }
}
