package project.rest.dto;

public class ReaderLoginDTO {
    private String readerName;
    private String password;

    public  String getReaderName(){ return readerName;}
    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getPassword(){ return password;}
    public void setPassword(String password){
        this.password = password;
    }
}
