import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabTask {
    StringBuilder string;

    public LabTask() {
    }

    public LabTask(String string) {
        this.string = new StringBuilder(string);
    }
    public static String doTask(String s){
        StringBuilder string = new StringBuilder(s);
        deleteBrackets(string);
        deleteAsterisks(string);
        return string.toString();
//        int firstScope = s.indexOf("(");
//        int lastScope = s.lastIndexOf(")") + 1;
//        int firstAsterisk = s.indexOf("*");
//        int lastAsterisk = s.lastIndexOf("*") + 1;
//        if((lastAsterisk != firstAsterisk) && (lastAsterisk*firstAsterisk > 0) && (firstScope != -1) && (lastScope != -1)){
//
//        }
//        System.out.println(firstScope);
//        System.out.println(lastScope);
//        string.delete(Math.min(firstAsterisk, firstScope), Math.max(lastScope, lastAsterisk));
//        return string.toString();

    }
    public static StringBuilder deleteBrackets(StringBuilder string){
//        StringBuilder string = new StringBuilder(s);
        int firstScope = string.indexOf("(");
        int lastScope = string.lastIndexOf(")");
        if((firstScope != -1) && (lastScope != -1)){
            string.delete(firstScope, lastScope + 1);
        }
        return string;
    }
    public static StringBuilder deleteAsterisks(StringBuilder string){
//        StringBuilder string = new StringBuilder(s);
        int firstAsterisk = string.indexOf("*");
        int lastAsterisk = string.lastIndexOf("*");
        if((lastAsterisk != firstAsterisk) && (lastAsterisk*firstAsterisk > 0)){
            System.out.println(lastAsterisk);
            System.out.println(firstAsterisk);
            string.delete(firstAsterisk, lastAsterisk + 1);
        }
        return string;
    }

    public static boolean checkPassword(String pw) throws Exception {
        char[] charPw = pw.toCharArray();
        boolean haveDigit = false;
        boolean haveUpperCase= false;
        boolean haveLowCase = false;

        if(pw.length() < 8){
            throw new Exception("Password don't have enough length");
        }
        for (int i = 0; i < charPw.length; i++) {

        }
        for (char c:
             charPw) {
            if(Character.isDigit(c)){
                haveDigit = true;
            }
            if(Character.isUpperCase(c)){
                haveUpperCase = true;
            }
            if(Character.isLowerCase(c)){
                haveLowCase = true;
            }
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pw);
        boolean haveSpecialSymbols = m.find();

        if(!haveDigit){
            throw new Exception("Password don't have any digits");
        }
        if(!haveUpperCase){
            throw new Exception("Password don't have any uppercase characters");
        }
        if(!haveLowCase){
            throw new Exception("Password don't have any lowercase characters");
        }
        if(!haveSpecialSymbols){
            throw new Exception("Password don't have any special symbols");
        }
        return true;
    }
}
