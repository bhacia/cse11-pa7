import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class StringSearch {
    public static void main(String[] args) throws IOException {
        //file, query, and tranform should come from terminal
        String contents = Files.readString(Paths.get(args[0]));
        String[] lines = contents.split("\n");
        if(args.length == 1) {
            for(int i = 0; i < lines.length; i += 1) {
                System.out.println(lines[i]);
            }
        }
    }
}