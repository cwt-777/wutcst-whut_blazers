package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;


public class Room
{
    //房间描述
    private String description;
    //出口
    private HashMap<String, Room> exits;        // stores exits of this room.（这个房间的出口）
    //物品
    private List<Object> objects = new ArrayList<>();

    //走过的房间（用于处理back）
    public static List<Room> trail = new ArrayList<>();

    //初始化
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();

    }

    /**
     * 出口 下一个房间.
     *
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }


    /**
     * 物品.
     * @param describe 物品的描述
     * @param weight 物品的重量
     *
     */
    public void setObjectToROOm(String describe,int weight){
        Object object=new Object(describe,weight);
        objects.add(object);
    }

    //获取物品
    public List<cn.edu.whut.sept.zuul.Object> getObjectList()
    {
        //没东西
        if(objects==null||objects.size()==0)
        {
            System.out.println("this room is empty");
        }
        //有东西
        else {
            for (Object i : objects) {
                if (i != null) {
                    System.out.println(i.getDescribe() + " weight:" + i.getWeight());
                }
            }
        }
        return objects;
    }
    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    //出口
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * 出口房间.
     * @param direction 房间描述
     * @return Room 房间
     *
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

}


