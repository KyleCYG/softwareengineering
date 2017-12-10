package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
  private static List<String> messages;

  private static List<String> getMessageList() {
    if (messages == null) {
      messages = new ArrayList<String>();
    }
    return messages;
  }

  public static void addMessage(String message) {
    getMessageList().add(message);
  }

  public static boolean hasMessages() {
    return getMessageList().size() > 0;
  }

  public static void clear() {
    messages = null;
  }

  public static List<String> getMessages() {
    return messages;
  }
}
