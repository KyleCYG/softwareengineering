package softwareengineering.scarlet.coursework2.models;

import java.util.LinkedList;
import java.util.Queue;

public class MessageList {
  private Queue<String> messages;

  public MessageList() {
    messages = new LinkedList<String>();
  }

  public void addMessage(String message) {
    messages.add(message);
  }

  public boolean hasMessages() {
    return messages.peek() != null;
  }

  public String getMessage() {
    return messages.poll();
  }
}
