package cn.edu.whut.sept.zuul;

public abstract class Command
{
    //第二个元素
    private String secondWord;

    public Command()
    {
        secondWord = null;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    //执行
    public abstract boolean execute(Game game);
}
