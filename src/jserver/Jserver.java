package jserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Mai Thành Duy An
 */
public class Jserver {
	public static void main(String[] args) throws IOException {
		int port = 9000;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/", new RootHandler());
		server.createContext("/echoHeader", new HeaderHandler());
		server.createContext("/echoGet", new GetHandler());
		server.createContext("/echoPost", new PostHandler());
		server.setExecutor(null);
		server.start();
		System.out.println("Server start at port: " + port);
	}
}
