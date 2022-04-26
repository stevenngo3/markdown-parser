import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks(){
        String toTest = "[link1](https://something.co) [link2](some-things.html)";
        
        MarkdownParseTest test = new MarkDownParse();

        ArrayList<String> result = new ArrayList<>();
        result.add("https://something.com");
        result.add("some-thing.html");

        assertEquals(result, test.getLinks(""));

    }
}
