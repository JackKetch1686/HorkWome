package Echoserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",5000);
        Scanner scanner = new Scanner(System.in);
        Stream<String> lines = Stream.generate(scanner::nextLine);
        PrintStream out = new PrintStream(socket.getOutputStream());
        lines.forEach(out::println);
    }
}
