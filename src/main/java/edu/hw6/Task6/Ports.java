package edu.hw6.Task6;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
public class Ports {
    public static final Map<Integer, String> PORTS = new TreeMap<>();

    static {
        PORTS.put(80, "HTTP");
        PORTS.put(21, "FTP");
        PORTS.put(25, "SMTP");
        PORTS.put(22, "SSH");
        PORTS.put(443, "HTTPS");
        PORTS.put(53, "DNS");
        PORTS.put(3306, "MySQL Database");
        PORTS.put(5432, "PostgreSQL Database");
        PORTS.put(3389, "Remote Desktop Protocol (RDP)");
        PORTS.put(1521, "Oracle Database");
        PORTS.put(5353, "Multicast Domain Name System");
        PORTS.put(5672, "Advanced Message Queuing Protocol");
        PORTS.put(5355, "Link-Local Multicast Name Resolution");
        PORTS.put(23, "Telnet");
        PORTS.put(110, "POP3");
        PORTS.put(143, "IMAP");
        PORTS.put(67, "DHCP");
        PORTS.put(68, "DHCP");
        PORTS.put(123, "NTP");
        PORTS.put(161, "SNMP");
        PORTS.put(162, "SNMP");
        PORTS.put(445, "Microsoft-DS Active Directory");
        PORTS.put(548, "AFP");
        PORTS.put(135, "EPMAP");
        PORTS.put(137, "Служба имен NetBIOS");
        PORTS.put(138, "Служба датаграмм NetBIOS");
        PORTS.put(139, "Служба сеансов NetBIOS");
        PORTS.put(843, "Adobe Flash");
        PORTS.put(1900, "Simple Service Discovery Protocol (SSDP)");
        PORTS.put(3702, "Динамическое обнаружение веб-служб");
        PORTS.put(6771, "PolyServe https");
        PORTS.put(6881, "Bit Torrent P2P");
        PORTS.put(8588, "EMC2 (Legato) Networker or Sun Solcitice Backup");
        PORTS.put(8590, "EMC2 (Legato) Networker or Sun Solcitice Backup");
        PORTS.put(9080, "EMC2 (Legato) Networker or Sun Solcitice Backup");
        PORTS.put(9797, "EMC2 (Legato) Networker or Sun Solcitice Backup");
    }

    private Ports() {
    }
}
