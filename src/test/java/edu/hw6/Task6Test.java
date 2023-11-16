package edu.hw6;

import edu.hw6.Task6.PortChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Used ports test")
    public void usedPortsTest() {
        String expected = """
                Protocol  Port   Service
                TCP       135    EPMAP
                UDP       137    Служба имен NetBIOS
                UDP       138    Служба датаграмм NetBIOS
                TCP       139    Служба сеансов NetBIOS
                TCP       445    Microsoft-DS Active Directory
                UDP       1900   Simple Service Discovery Protocol (SSDP)
                UDP       5353   Multicast Domain Name System
                UDP       5355   Link-Local Multicast Name Resolution
                UDP       6771   PolyServe https
                TCP       6881   Bit Torrent P2P
                UDP       6881   Bit Torrent P2P
                TCP       8588   EMC2 (Legato) Networker or Sun Solcitice Backup
                TCP       8590   EMC2 (Legato) Networker or Sun Solcitice Backup
                TCP       9080   EMC2 (Legato) Networker or Sun Solcitice Backup
                TCP       9797   EMC2 (Legato) Networker or Sun Solcitice Backup
                """;

        Assertions.assertEquals(expected, PortChecker.informationAboutOwners());
    }
}
