package main;

import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException, RateLimitException {

    Bridges bridges = new Bridges(123, "ttkac503", "1544315518727");
    bridges.setTitle("Netflix Movies and TV shows");
    bridges.setDescription("Movies are in green, TV shows are in red");

    SimpleLinkedList<List<String>> records = new SimpleLinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        records.append(Arrays.asList(values));

        SLelement<List<String>> tail = records.getTail();

        tail.setLabel(tail.getValue().get(2));

        if ("Movie".equals(tail.getValue().get(1))) {
          tail.setColor("green");
        } else {
          tail.setColor("red");
        }
      }

      bridges.setDataStructure(records.getHead());
      bridges.visualize();
    }
  }
}
