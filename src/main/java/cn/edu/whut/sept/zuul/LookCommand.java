package cn.edu.whut.sept.zuul;

public class LookCommand extends Command{

    //输入look字符
    public boolean execute(Game game)
    {
        Room nowRoom= game.getCurrentRoom();
        System.out.println(nowRoom.getShortDescription());
        nowRoom.getObjectList();
        return false;
    }

}
