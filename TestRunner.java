import java.lang.Thread;

public class TestRunner {

   

   public static void main(String[] args) {

      Thread tUser = new Thread(new TwitterUser("barun"));

      tUser.start();
   }

   

}
