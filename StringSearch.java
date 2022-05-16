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
        else if(args.length == 2) {
            if(args[1].contains("length=")) {
                Query.Length(args, lines);
            }
            if(args[1].contains("greater=")) {
                Query.Greater(args, lines);
            }
            if(args[1].contains("less=")) {
                Query.Less(args, lines);
            }
            if(args[1].contains("contains=")) {
                Query.Contains(args, lines);
            }
            if(args[1].contains("starts=")) {
                Query.Starts(args, lines);
            }
            if(args[1].contains("ends=")) {
                Query.Ends(args, lines);
            }
        }
        else if(args.length == 3) {
            if(args[2].contains("upper")) {
                Transform.Upper(args, lines);
            }
            if(args[2].contains("lower")) {
                Transform.Lower(args, lines);
            }
            if(args[2].contains("first")) {
                Transform.First(args, lines);
            }
            if(args[2].contains("last")) {
                Transform.Last(args, lines);
            }
            if(args[2].contains("replace")) {
                Transform.Replace(args, lines);
            }
            if(args[1].contains("length=")) {
                Query.Length(args, lines);
            }
            if(args[1].contains("greater=")) {
                Query.Greater(args, lines);
            }
            if(args[1].contains("less=")) {
                Query.Less(args, lines);
            }
            if(args[1].contains("contains=")) {
                Query.Contains(args, lines);
            }
            if(args[1].contains("starts=")) {
                Query.Starts(args, lines);
            }
            if(args[1].contains("starts=")) {
                Query.Contains(args, lines);
            }
            if(args[1].contains("ends=")) {
                Query.Ends(args, lines);
            }
        }
    }
}
class Query {
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
                    }
                    System.out.println(tempLines[i].substring(0, num));
                    break;
                }
            }
        }
    }
    static void Greater(String[] tempArgs, String[] tempLines) {
        int num = 0;
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&greater=")) {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("greater=") + 8, tempArgs[1].length() - 1));
            }
            else {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("greater=") + 8, tempArgs[1].indexOf("&")));
            }
        }
        else {
            num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("greater=") + 8, tempArgs[1].length() - 1));
        }
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
        int num = 0;
        if(tempArgs[1].contains("&")) {
            if(tempArgs[1].contains("&less=")) {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("less=") + 5, tempArgs[1].length() - 1));
            }
            else {
                num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("less=") + 5, tempArgs[1].indexOf("&")));
            }
        }
        else {
            num += Integer.parseInt(tempArgs[1].substring(tempArgs[1].indexOf("less=") + 5, tempArgs[1].length() - 1));
        }
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
    static void Not(String[] tempArgs, String[] tempLines) {
        //I'm not sure where to start
    }
}
class Transform {
    static void Upper(String[] tempArgs, String[] tempLines) {
        for(int i = 0; i < tempLines.length; i += 1) {
            tempLines[i] = tempLines[i].toUpperCase();
        }
    }
    static void Lower(String[] tempArgs, String[] tempLines) {
        for(int i = 0; i < tempLines.length; i += 1) {
            tempLines[i] = tempLines[i].toLowerCase();
        }
    }
    static void First(String[] tempArgs, String[] tempLines) {
        int num = 0;
        if(tempArgs[2].contains("&")) {
            if(tempArgs[2].contains("&first=")) {
                num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("first=") + 6, tempArgs[2].length() - 1));
            }
            else {
                num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("first=") + 6, tempArgs[2].indexOf("&")));
            }
        }
        else {
            num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("first=") + 6, tempArgs[2].length() - 1));
        }
        for(int i = 0; i < tempLines.length; i += 1) {
            tempLines[i] = tempLines[i].substring(0, num);
        }
    }
    static void Last(String[] tempArgs, String[] tempLines) {
        int num = 0;
        if(tempArgs[2].contains("&")) {
            if(tempArgs[2].contains("&last=")) {
                num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("last=") + 5, tempArgs[2].length() - 1));
            }
            else {
                num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("last=") + 5, tempArgs[2].indexOf("&")));
            }
        }
        else {
            num += Integer.parseInt(tempArgs[2].substring(tempArgs[2].indexOf("last=") + 5, tempArgs[2].length() - 1));
        }
        for(int i = 0; i < tempLines.length; i += 1) {
            int chars = (num - tempLines[i].length()) * -1;
            tempLines[i] = tempLines[i].substring(chars, tempLines[i].length());
        }
    }
    static void Replace(String[] tempArgs, String[] tempLines) { 
        String toReplace = tempArgs[2].substring(tempArgs[2].indexOf("replace=") + 9, tempArgs[2].indexOf(";") - 1);
        String replaceWith = tempArgs[2].substring(tempArgs[2].indexOf(";") + 2, tempArgs[2].length() - 1);
        for(int i = 0; i < tempLines.length; i += 1) {
            tempLines[i] = tempLines[i].replace(toReplace, replaceWith);
        }
    }
}

/*
  This is really not an ideal way to do this, but I'll just explain my issues.
  Most of my queries are fine, but if I try a transform with it, it won't
  exactly go through, or combine together. I was trying to make it so that
  the transform goes first, then the query can work with the transformed text
  and print out what it needs to, but it didn't work out.
*/