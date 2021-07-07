package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Iterator;

public class CommandWords
{
    private HashMap<String, Command> commands;


    //go help quit look
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("look",new LookCommand());
        commands.put("back",new BackCommand());
        commands.put("seniorBack",new SeniorBackCommand());
        commands.put("take",new TakeCommand());
        commands.put("drop",new DropCommand());
        commands.put("items",new ItemsCommand());
        commands.put("eat-cookie",new EatCookieCommand());
    }

    public Command get(String word)
    {
        return commands.get(word);
    }

    //所有选择
    public void showAll()
    {
        for(Iterator i = commands.keySet().iterator(); i.hasNext(); ) {
            System.out.print(i.next() + "  ");
        }
        System.out.println();
    }
}
