package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connection.getRemoteSocketAddress());
            }

        }
    }

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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST, "Пожалуйста, введите Ваше имя."));
            Message message = connection.receive();
            String name = message.getData();
            if (message.getType().equals(MessageType.USER_NAME) && Objects.nonNull(name) &&
                    !name.isEmpty() && !connectionMap.containsKey(name)) {
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED, "Добро пожаловать в АД!!!" + name));
                return name;
            } else {
                ConsoleHelper.writeMessage("Ошибка ввода имени пользователя.");
                return serverHandshake(connection);
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            Set<String> keySet = connectionMap.keySet();
            for (String user : keySet) {
                if (!user.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, user));
                }
            }
        }


    }


}
