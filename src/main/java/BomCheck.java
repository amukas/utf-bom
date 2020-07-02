import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class BomCheck {
    //export LC_ALL=en_US.UTF-8
    public static void main(String[] args) throws Exception {
        byte[] withBom = Files.readAllBytes(Paths.get("test-data.txt"));
        System.out.println("current encoding: " + Charset.defaultCharset());
        String withOutBom = "{node: 123}\n";
        String str = new String(withBom, StandardCharsets.UTF_8).replaceAll("[\uFEFF-\uFFFF]", "");
        System.out.println(Arrays.toString(str.toCharArray()));
        System.out.println("withOutBom.equals(str): " + withOutBom.equals(str));
    }
}
