import java.lang.Runnable;
import java.util.ArrayList;

public class TwitterUser implements Runnable {
   public static enum Operation {CREATEUSER, LOGIN, TWEET, LISTFOLLOWERS, LISTTWEET, FOLLOW, UNFOLLOW};

   String username;
   String password;
   String userModelFile;
   TwitterService service;

   private ArrayList<Operation> ops;

   public TwitterUser(String username, String password) {
      this.service = new TwitterService();
      this.userModelFile = null;

      this.username = username;
      this.password = password;
   }

   public TwitterUser(String userModelFile) {
      this.service = new TwitterService();
      this.userModelFile = userModelFile;

      this.username = "Test";
      this.password = "Password";
      prepareUser(userModelFile);
   }

   public void run() {
      try {
         if (userModelFile == null) {
            genericUserModel();
         } else {
            userActions();
         }
      } catch (Exception e) {
         System.out.println("There are issues in threading.");
      }
   }

   private void genericUserModel() {
      service.createUser(username, password);
      service.login(username, password);
      service.tweet("Tweet from " + username);
      service.listFollowers();
      service.listTweets(); 
   }

   private void prepareUser(String userModelFile) {
      ops = new ArrayList<Operation>();

      ops.add(Operation.CREATEUSER);
      ops.add(Operation.CREATEUSER);
      ops.add(Operation.LOGIN);
      ops.add(Operation.LOGIN);
      ops.add(Operation.TWEET);
      ops.add(Operation.TWEET);
      ops.add(Operation.TWEET);
      ops.add(Operation.TWEET);
   }

   private void userActions() {
      for (Operation operation : ops) {
         switch(operation) {
         case CREATEUSER:
               service.createUser(username, password);
            break;
         case LOGIN:
               service.login(username, password);
            break;
         case TWEET:
               service.tweet("Tweet from " + username);
            break;
         }
      }
   }

}
