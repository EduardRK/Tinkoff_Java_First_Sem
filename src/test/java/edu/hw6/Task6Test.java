package edu.hw6;

import edu.hw6.Task6.PortChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Used ports test")
    public void usedPortsTest() {
        StringBuilder expected = new StringBuilder();
        expected.append("Protocol  Port   Service").append('\n')
            .append("TCP       135    EPMAP").append('\n')
            .append("UDP       137    Служба имен NetBIOS").append('\n')
            .append("UDP       138    Служба датаграмм NetBIOS").append('\n')
            .append("TCP       139    Служба сеансов NetBIOS").append('\n')
            .append("TCP       445    Microsoft-DS Active Directory").append('\n')
            .append("UDP       1900   Simple Service Discovery Protocol (SSDP)").append('\n')
            .append("UDP       5353   Multicast Domain Name System").append('\n')
            .append("UDP       5355   Link-Local Multicast Name Resolution").append('\n')
            .append("UDP       6771   PolyServe https").append('\n')
            .append("TCP       6881   Bit Torrent P2P").append('\n')
            .append("UDP       6881   Bit Torrent P2P").append('\n')
            .append("TCP       8588   EMC2 (Legato) Networker or Sun Solcitice Backup").append('\n')
            .append("TCP       8590   EMC2 (Legato) Networker or Sun Solcitice Backup").append('\n')
            .append("TCP       9080   EMC2 (Legato) Networker or Sun Solcitice Backup").append('\n')
            .append("TCP       9797   EMC2 (Legato) Networker or Sun Solcitice Backup").append('\n');

        Assertions.assertEquals(expected.toString(), PortChecker.informationAboutOwners());
    }
}
