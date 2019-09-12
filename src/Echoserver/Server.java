package Echoserver;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverDoorMan = new ServerSocket(5000);
        Socket socketToClient  = serverDoorMan.accept();
        Scanner scanner = new Scanner(socketToClient.getInputStream());
        Stream<String> lines = Stream.generate(scanner::nextLine).takeWhile(s -> scanner.hasNextLine());
        lines.forEach(System.out::println);
    }
}
