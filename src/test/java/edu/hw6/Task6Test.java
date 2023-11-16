package edu.hw6;

import edu.hw6.Task6.PortChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("Used ports works without errors")
    public void usedPortsWorksWithoutError() {
        PortChecker.informationAboutOwners();
    }
}
