package cn.edu.whut.sept.zuul;

import java.util.List;

public class TakeCommand extends Command{

    //捡物品
    public boolean execute(Game game) {
        List<cn.edu.whut.sept.zuul.Object> objects = game.getCurrentRoom().getObjectList();
        if(objects == null || objects.size() == 0){
            System.out.println("You can't pick up anything,because the room is empty!");
        }else{
            List<Object> newObjects = game.getPlayer().getObjects();
            for(int i = 0;i < objects.size();i++){
                newObjects.add(objects.get(i));
            }
            game.getPlayer().setObjects(newObjects);
            System.out.println("You have picked up the item!");
        }
        return false;
    }
}
