package cn.edu.whut.sept.zuul;

import java.util.List;
import java.util.Scanner;

public class DropCommand extends Command{

    //丢物品
    public boolean execute(Game game) {
        List<Object> objects = game.getPlayer().getObjects();
        if(objects == null || objects.size() == 0){
            System.out.println("You can't lose things because you don't have them!");
        }else{
            String playerObjectsDescription = "";
            for(int i = 0;i < game.getPlayer().getObjects().size();i++){
                playerObjectsDescription = playerObjectsDescription + game.getPlayer().getObjects().get(i).getDescribe() + "  ";
            }
            System.out.println("What do you want to lose?" + playerObjectsDescription);
            Scanner scanner = new Scanner(System.in);
            String chooseObject = scanner.next();
            for(int i = 0;i < game.getPlayer().getObjects().size();i++){
                if(chooseObject.equals(game.getPlayer().getObjects().get(i).getDescribe())){
                    game.getPlayer().getObjects().remove(i);
                }
            }
            System.out.println("You have lose the item!");
        }
        return false;
    }
}
