import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class StringSearch {
    public static void main(String[] args) throws IOException {
        //file, query, and tranform should come from terminal
        String contents = Files.readString(Paths.get(args[0]));
        String[] lines = contents.split("\n");
        if(args.length == 3) {
            if(args[2].contains("upper")) {
                TransformMS4.Upper(args, lines);
            }
            if(args[1].contains("contains=")) {
                QueryMS4.Length(args, lines);
            }
        }
    }
}
class QueryMS4 {
    static void Length(String[] tempArgs, String[] tempLines) {
        int num = 0;
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&length=")) {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("length=") + 7, tempArgs[1].length()));
            }
            else {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("length=") + 7, tempArgs[1].indexOf("&")));
            }
        }
        else {
            num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("length=") + 7, tempArgs[1].length()));
        }
        if(tempLines[0].length() >= num) {
            System.out.println(tempLines[0].substring(0, num));
        }
        else {
            int chars = tempLines[0].length();
            for(int i = 1; i < tempLines.length; i += 1) {
                chars += tempLines[i].length();
                if(chars >= num) {
                    for(int j = 0; j < i; j += 1) {
                        System.out.println(tempLines[j]);
                        num -= tempLines[j].length();
                        System.out.println(tempLines[i].substring(0, num));
                    }
                    break;
                }
            }
        }
    }
}
class TransformMS4 {
    static void Upper(String[] tempArgs, String[] tempLines) {
        for(int i = 0; i < tempLines.length; i += 1) {
            tempLines[i] = tempLines[i].toUpperCase();
        }
    }
}