package edu.hw6;

import edu.hw6.Task6.PortChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Used ports test")
    public void usedPortsTest() {
        String expected = "Protocol  Port   Service" + '\n' +
            "TCP       135    EPMAP" + '\n' +
            "UDP       137    Служба имен NetBIOS" + '\n' +
            "UDP       138    Служба датаграмм NetBIOS" + '\n' +
            "TCP       139    Служба сеансов NetBIOS" + '\n' +
            "TCP       445    Microsoft-DS Active Directory" + '\n' +
            "UDP       1900   Simple Service Discovery Protocol (SSDP)" + '\n' +
            "UDP       5353   Multicast Domain Name System" + '\n' +
            "UDP       5355   Link-Local Multicast Name Resolution" + '\n' +
            "UDP       6771   PolyServe https" + '\n' +
            "TCP       6881   Bit Torrent P2P" + '\n' +
            "UDP       6881   Bit Torrent P2P" + '\n' +
            "TCP       8588   EMC2 (Legato) Networker or Sun Solcitice Backup" + '\n' +
            "TCP       8590   EMC2 (Legato) Networker or Sun Solcitice Backup" + '\n' +
            "TCP       9080   EMC2 (Legato) Networker or Sun Solcitice Backup" + '\n' +
            "TCP       9797   EMC2 (Legato) Networker or Sun Solcitice Backup" + '\n';

        Assertions.assertEquals(expected, PortChecker.informationAboutOwners());
    }
}
