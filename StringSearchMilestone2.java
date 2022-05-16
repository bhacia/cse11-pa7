import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class StringSearch {
    public static void main(String[] args) throws IOException {
        //file, query, and tranform should come from terminal
        String contents = Files.readString(Paths.get(args[0]));
        String[] lines = contents.split("\n");
        if(args.length == 2) {
            if(args[1].contains("contains=")) {
                QueryMS2.Contains(args, lines);
            }
        }
    }
}
class QueryMS2 {
    static void Contains(String[] tempArgs, String[] tempLines) {
        String toFind = "";
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&contains=")) {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("contains=") + 10, tempArgs[1].length() - 1);
            }
            else {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("contains=") + 10, tempArgs[1].indexOf("&"));
            }
        }
        else {
            toFind += tempArgs[1].substring(tempArgs[1].indexOf("contains=") + 10, tempArgs[1].length() - 1);
        }
        for(int i = 0; i < tempLines.length; i += 1) {
            if(tempLines[i].contains(toFind)) {
                System.out.println(tempLines[i]);
            }
        } 
    }
}