import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class StringSearch {
    public static void main(String[] args) throws IOException {
        //file, query, and tranform should come from terminal
        String contents = Files.readString(Paths.get(args[0]));
        String[] lines = contents.split("\n");
        if(args.length == 2) {
            if(args[1].contains("length=")) {
                QueryMS3.Length(args, lines);
            }
            if(args[1].contains("greater=")) {
                QueryMS3.Greater(args, lines);
            }
            if(args[1].contains("less=")) {
                QueryMS3.Less(args, lines);
            }
            if(args[1].contains("contains=")) {
                QueryMS3.Contains(args, lines);
            }
            if(args[1].contains("starts=")) {
                QueryMS3.Starts(args, lines);
            }
            if(args[1].contains("ends=")) {
                QueryMS3.Ends(args, lines);
            }
        }
    }
}
class QueryMS3 {
    static void Length(String[] tempArgs, String[] tempLines) {
        int num = Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("length=") + 7, tempArgs[1].length()));
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
                    }
                    System.out.println(tempLines[i].substring(0, num));
                    break;
                }
            }
        }
    }
    static void Greater(String[] tempArgs, String[] tempLines) {
        int num = Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("greater=") + 8, tempArgs[1].length() - 1));
        if(tempLines[0].length() > num) {
            System.out.println(tempLines[0]);
            System.out.println(tempLines[1]);
        }
        else {
            int chars = tempLines[0].length();
            for(int i = 1; i < tempLines.length; i += 1) {
                chars += tempLines[i].length();
                if(chars >= num) {
                    for(int j = 0; j <= i; j += 1) {
                        System.out.println(tempLines[j]);
                    }
                    break;
                }
            }
        }
    }
    static void Less(String[] tempArgs, String[] tempLines) { 
        int num = Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("less=") + 5, tempArgs[1].length() - 1));
        if(tempLines[0].length() < num) {
            System.out.println(tempLines[0]);
        }
        else {
            int chars = tempLines[0].length();
            for(int i = 1; i < tempLines.length; i += 1) {
                chars += tempLines[i].length();
                if(chars >= num) {
                    for(int j = 0; j < i; j += 1) {
                        System.out.println(tempLines[j]);
                    }
                    break;
                }
            }
        }
    }
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
    static void Starts(String[] tempArgs, String[] tempLines) {
        String toFind = "";
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&starts=")) {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("starts=") + 8, tempArgs[1].length() - 1);
            }
            else {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("starts=") + 8, tempArgs[1].indexOf("&"));
            }
        }
        else {
            toFind += tempArgs[1].substring(tempArgs[1].indexOf("starts=") + 8, tempArgs[1].length() - 1);
        }
        for(int i = 0; i < tempLines.length; i += 1) {
            if(tempLines[i].substring(0, toFind.length()).equals(toFind)) {
                System.out.println(tempLines[i]);
            }
        }
    }
    static void Ends(String[] tempArgs, String[] tempLines) {
        String toFind = "";
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&ends=")) {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("ends=") + 6, tempArgs[1].length() - 1);
            }
            else {
                toFind += tempArgs[1].substring(tempArgs[1].indexOf("ends=") + 6, tempArgs[1].indexOf("&"));
            }
        }
        else {
            toFind += tempArgs[1].substring(tempArgs[1].indexOf("ends=") + 6, tempArgs[1].length() - 1);
        }
        for(int i = 0; i < tempLines.length; i += 1) {
            int newLength = tempLines[i].length() - toFind.length();
            if(tempLines[i].substring(newLength, tempLines[i].length()).equals(toFind)) {
                System.out.println(tempLines[i]);
            }
        }
    }
}