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

    @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("snippet-1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
    
        assertEquals(expected, links);
    }
