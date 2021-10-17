public class Case{
    //Au tennis la balle doit arrive dans le
    boolean service;
    boolean nonservice;
    int x;
    int y;
    private String emoji;

    public Case(boolean service,boolean nonservice,int x,int y,String emoji){
        this.service=service;
        this.nonservice=nonservice;
        this.x=x;
        this.y=y;
        this.emoji=emoji;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}