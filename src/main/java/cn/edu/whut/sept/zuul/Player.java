package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //姓名
    private String name;
    //当前房间
    private Room currentRoom;

    //负重能力（初始值1000）
    private int weightPower = 1000;

    //物品
    private List<cn.edu.whut.sept.zuul.Object> objects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public int getWeightPower() {
        return weightPower;
    }

    public void setWeightPower(int weightPower) {
        this.weightPower = weightPower;
    }
}
