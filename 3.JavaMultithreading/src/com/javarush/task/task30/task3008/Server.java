package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket accepted = serverSocket.accept();
                Handler handler = new Handler(accepted);
                handler.start();
            }

        } catch (IOException e) {
            ConsoleHelper.writeMessage("При запуске произошла ошибка");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }


}
