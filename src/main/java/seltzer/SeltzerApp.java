package seltzer;

public class SeltzerApp {

    public static void main(String[] args){
        if(args.length > 0){
            if(args[0].equals("test")){
                seltzer.CSVDelegate.doTestWriting();
            }
        }
       // CSVDelegate.updateFileContents();
        SeltzerPopup p = new SeltzerPopup(null);
        p.setVisible(true);


    }
}
