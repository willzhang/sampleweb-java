import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleWebServer {

    public static void main(String[] args) throws IOException {
        // 创建HttpServer实例，绑定到8080端口
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // 创建上下文并设置处理器
        server.createContext("/", new MyHttpHandler());
        // 启动服务器
        server.start();
        System.out.println("Server is running on http://localhost:8080/");
    }

    static class MyHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World! This is a simple web server.";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
