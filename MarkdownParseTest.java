import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile10() throws IOException {
        String contents= Files.readString(Path.of("./test-file10.md"));
        List<String> expect = List.of("`google.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }    

    @Test
    public void testFile11() throws IOException {
        String contents= Files.readString(Path.of("./test-file11.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }  

    @Test
    public void testFile12() throws IOException {
        String contents= Files.readString(Path.of("./test-file12.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }  
}
