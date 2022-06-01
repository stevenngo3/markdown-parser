//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();

        int currentIndex = 0;
        if (!markdown.contains("[")){
            return toReturn; 
        } 

        else if (!markdown.contains("[")){
            return toReturn; 
        }

        else if (!markdown.contains("]")){
            return toReturn; 
        }

        else if (!markdown.contains("(")){
            return toReturn; 
        }

        else if (!markdown.contains(")")){
            return toReturn; 
        }

        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            int parenTotal = openParen + closeBracket; 
            int bracketTotal = openBracket + closeBracket; 
            if (parenTotal < bracketTotal){
                return toReturn;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            if (!markdown.substring(currentIndex,markdown.length()).contains("[")
            || !markdown.substring(currentIndex,markdown.length()).contains("]")) {
                return toReturn;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
