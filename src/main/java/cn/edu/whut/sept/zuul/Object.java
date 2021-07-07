package cn.edu.whut.sept.zuul;

//物品
public class Object {
    private String describe;
    private int weight;

    public Object(String describe,int weight) {
        this.describe=describe;
        this.weight=weight;

    }


    public String getDescribe()
    {
        return describe;
    }
    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString() {
        return "Object{" +
                "describe='" + describe + '\'' +
                ", weight=" + weight +
                '}';
    }
}
