package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.List;

public class GoCommand extends Command
{
    //输入go字符
    public boolean execute(Game game)
    {
        //没有第二个字符
        if(!hasSecondWord()) {
            System.out.println("Go where?");
        }

        List<Room> rooms = new ArrayList<Room>();

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //把房间加入到轨迹中
            Room.trail.add(nextRoom);
            game.setCurrentRoom(nextRoom);
            //传输门
            if(nextRoom.getShortDescription().equals("You've entered the portal, transmitting...")){
                System.out.println(nextRoom.getLongDescription());
                //随机数
                int random = (int)(Math.random() * 7 + 1);
                if(random == 1){
                    nextRoom = Game.office;
                    System.out.println(nextRoom.getLongDescription());
                }
                if(random == 2){
                    nextRoom = Game.outside;
                    System.out.println(nextRoom.getLongDescription());
                }
                if(random == 3){
                    nextRoom = Game.pub;
                    System.out.println(nextRoom.getLongDescription());
                }
                if(random == 4){
                    nextRoom = Game.theater;
                    System.out.println(nextRoom.getLongDescription());
                }else{
                    nextRoom = Game.lab;
                    System.out.println(nextRoom.getLongDescription());
                }
            }else{
                System.out.println(nextRoom.getLongDescription());
            }
        }

        return false;
    }
}
