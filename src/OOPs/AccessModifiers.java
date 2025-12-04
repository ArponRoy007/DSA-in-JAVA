package OOPs;

public class AccessModifiers {
    public static void main(String[] args) {
        BankAccount b1=new BankAccount();
        b1.username="Roy Arpon";
        b1.setPass("asdfghjkl");
    }
}

class BankAccount{
    public String username;
    private String password;

    public void setPass(String pwd){
        password=pwd;
    }
}


