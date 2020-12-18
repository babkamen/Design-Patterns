import com.babkamen.bridge.AdvancedRemote;
import com.babkamen.bridge.Remote;
import com.babkamen.bridge.TV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TVTest {

    @Test
    public void testRemote() {
        TV tv = new TV();
        Remote remote = new Remote(tv);

        remote.togglePower();
        assertTrue(tv.isEnabled());

        remote.channelDown();
        assertEquals(0, tv.getChannel());

        remote.channelUp();
        assertEquals(1, tv.getChannel());

        remote.channelUp();
        assertEquals(100, tv.getVolume());

        for (int i = 0; i < 100; i++) {
            remote.volumeDown();
        }
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testAdvancedRemote() {
        TV tv = new TV();
        AdvancedRemote remote = new AdvancedRemote(tv);

        remote.toggleMute();
        assertTrue(tv.isMuted());

        remote.toggleMute();
        assertFalse(tv.isMuted());
    }
}
