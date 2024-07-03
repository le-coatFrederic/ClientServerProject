package heptathlon;

import java.rmi.Naming;

public class Main {
    public static void main(String[] args) {
        try {
            String serverIP = "localhost:1099"; 
            IRmiSenderToClient communicationService = (IRmiSenderToClient) Naming.lookup("//" + serverIP + "/ClientGet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}