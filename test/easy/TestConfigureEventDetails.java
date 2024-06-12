package easy;

import org.junit.Before;
import org.junit.Test;
import main.ConfigureEventDetails;
import main.EventFactory;
import main.VenueFactory;
import main.NodeData;

public class TestConfigureEventDetails {

    private ConfigureEventDetails configureEventDetails;

    @Before
    public void setUp() throws Exception {
        configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
        configureEventDetails.setFileDataToAttributes();
    }

    @Test
    public void getObjectEventData() {
        NodeData nodeData = ConfigureEventDetails.getEventDataMap().get(10);
        nodeData.getEventData().printEventData(nodeData.getTicketsData());
    }
}