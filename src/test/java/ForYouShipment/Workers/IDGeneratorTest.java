package ForYouShipment.Workers;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class IDGeneratorTest {
    @Test
    public void TestRandomGenerator() {
        String a = IDGenerator.GetInstance().GenerateID();
        String b = IDGenerator.GetInstance().GenerateID();

        assertNotEquals(a, b);
    }

    
}
