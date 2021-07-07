/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

public class Game
{
    private Parser parser;
    //当前房间
    private Room currentRoom;

    //房间
    static Room outside, theater, pub, lab, office, portal;

    //玩家
    private Player player;


    public Game()
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        player.setName("玩家");
    }

    //房间：outside, theater, pub, lab, office ，portal(传送门)
    private void createRooms()
    {
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        outside.setObjectToROOm("book",1);
        outside.setObjectToROOm("haoye",99);
        theater = new Room("in a lecture theater");
        theater.setObjectToROOm("magic cookie",2);
        pub = new Room("in the campus pub");
        pub.setObjectToROOm("pen",1);
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        office.setObjectToROOm("magic cookie",100);
        portal = new Room("You've entered the portal, transmitting...");


        // initialise room exits
        //outside.setExit("east", theater);
        outside.setExit("east", portal);//东设置为传送门
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        portal.setExit("noExit", null);

        currentRoom = outside;  // start game outside

        Room.trail.add(currentRoom);
    }

    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        //finish可能用于通关游戏！！
        boolean finished = false;
        //游戏继续
        while (! finished) {
            Command command = parser.getCommand();
            //command哈希表中获取不到
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    //欢迎页
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}