package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;

public class PortChecker {
    private static final String FORMATTER_PROTOCOL = "%-10s";
    private static final String FORMATTER_PORT = "%-7s";
    private static final String NOT_AVAILABLE = "N/A";

    private PortChecker() {
    }

    public static String informationAboutOwners() {
        StringBuilder stringBuilder = listTitle();

        for (int port : Ports.PORTS.keySet()) {
            if (!isTCPPortAvailable(port)) {
                stringBuilder = addListItem(stringBuilder, "TCP", port);
            }
            if (!isUDPPortAvailable(port)) {
                stringBuilder = addListItem(stringBuilder, "UDP", port);
            }
        }
        return stringBuilder.toString();
    }

    private static StringBuilder listTitle() {
        return new StringBuilder()
            .append(String.format(FORMATTER_PROTOCOL, "Protocol"))
            .append(String.format(FORMATTER_PORT, "Port"))
            .append("Service")
            .append(System.lineSeparator());
    }

    private static StringBuilder addListItem(StringBuilder stringBuilder, String protocol, int port) {
        return stringBuilder.append(String.format(FORMATTER_PROTOCOL, protocol))
            .append(String.format(FORMATTER_PORT, port))
            .append(Ports.PORTS.getOrDefault(port, NOT_AVAILABLE))
            .append('\n');
    }

    private static boolean isTCPPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean isUDPPortAvailable(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            datagramSocket.setReuseAddress(true);
            return true;
        } catch (SocketException e) {
            return false;
        }
    }
}
