public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        LabTask labTask = new LabTask("here (will be deleted)");
//        LabTask labTask = new LabTask();
//        System.out.println(null);
        String modifiedString = LabTask.doTask("    here will *be *some (text deleted)       ").trim();
        System.out.println(modifiedString);
        System.out.println(modifiedString.split("\\s").length);
        try {
            System.out.println(LabTask.checkPassword("heH$hehe5"));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}