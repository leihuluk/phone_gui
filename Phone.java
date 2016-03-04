/**
This program uses different classes to model a cell phone. It creates an object,
which will reference another program to demo this object.
Leihulu Kenui
*/
public class Phone
{
    private String num, lastNum;
    
 /**
The Phone constructor will initialize a new phone object that does not 
have anything currently displayed.
*/
    public Phone()
    {
        num = "";
        lastNum = "";
    }

/**
The setNum method will set the num field to the value stored in the displayStr argument.
*/
    
    public void setNum(String displayStr)
    {
        num = displayStr;
    }
    
/**
The addToNum method will set the num field to the value stored in the num + ch argument.
*/
    
    public void addToNum(char ch)
    {
        num = num + ch;
    }
    
/**
The takeFromNum method will set the num field to display a blank field if 
the value stored in the num argument is less than 1.
*/    
    
    public void takeFromNum()
    {
        if(num.length() < 1) num = "";
        else
        {
            num = num.substring(0, num.length()-1);
        }
    }
    
/**
The clear method will set the num field to blank
*/
    public void clear()
    {
        num = "";
    }
    
/**
The setLastNum method will set the lastNum field to the value stored in the
displayStr argument.
*/
    
    public void setLastNum(String displayStr)
    {
        lastNum = displayStr;
    }
   
   /**
The getNum method will return the value of the num variable.
*/
    
    public String getNum()
    {
        return num;
    }
    
/**
The getLastNum method will return the value of the lastNum variable.
*/
    
    public String getLastNum()
    {
        return lastNum;
    }
   
}