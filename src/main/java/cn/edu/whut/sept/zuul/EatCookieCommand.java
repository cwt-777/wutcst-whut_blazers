package cn.edu.whut.sept.zuul;

public class EatCookieCommand extends Command{

    //吃饼干
    public boolean execute(Game game) {
        boolean existMagicCookie = false;
        int index = -1;
        for(int i = 0;i < game.getPlayer().getObjects().size();i++){
            //存在魔法饼干
            if(game.getPlayer().getObjects().get(i).getDescribe().equals("magic cookie")){
                existMagicCookie = true;
                index = i;
            }
        }
        if(existMagicCookie == true){
            System.out.println("Before you eat magic cookies your weightPower is " + game.getPlayer().getWeightPower());
            //加负重值
            game.getPlayer().setWeightPower(game.getPlayer().getWeightPower() + game.getPlayer().getObjects().get(index).getWeight());
            System.out.println("You eat magic cookies to increase your load.now your weightPower is " + game.getPlayer().getWeightPower());
        }else{
            System.out.println("You don't have magic cookies");
        }
        return false;
    }

}
