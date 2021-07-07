package cn.edu.whut.sept.zuul;

//高级返回
public class SeniorBackCommand extends Command {

    //高级返回
    public boolean execute(Game game) {
        //行动轨迹不空则证明可以返回
        while(Room.trail != null && Room.trail.size() != 0 && Room.trail.size() != 1) {
            //返回上一个房间
            Room nextRoom = Room.trail.get(Room.trail.size() - 2);
            //删除轨迹
            Room.trail.remove(Room.trail.size() - 1);
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }
        System.out.println("You're already in the beginning!");
        return false;
    }

}
