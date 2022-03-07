package hello;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.joda.time.LocalTime;

public class HelloWorld {

  public static void main(String[] args) throws Exception {
    Integer port = 8000;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/", new MyHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
    System.out.println("Started demo server on port: " + port);
  }

  static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      LocalTime currentTime = new LocalTime();
      String response = "Hello world. The current local time is: " + currentTime;
      t.sendResponseHeaders(200, response.length());

      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}
