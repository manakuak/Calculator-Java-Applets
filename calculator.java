import java.awt.*;
import java.awt.TextField.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Color.*;
/*<applet code="calculator" width=400 height=300>
</applet>
*/
public class calculator extends Applet implements ActionListener
{
	
	
	Button one,two,three,four,five,six,seven,eight,nine,zero,dec,clr;
	Button add,sub,mul,div,mod,equal;
	Button bList[]=new Button[18];
	TextField space;
	int res,a,b;
	Font fo;
	String str2="",operand="";
	boolean count=false,again=false;
	public void init()
	{
		fo=new Font("SansSerif",Font.BOLD,20);
		setFont(fo);
		Color co=new Color(100,100,250);
		setBackground(co);
		space=new TextField(100);
		space.setBounds(10,10,300,300);
		add(space);
		space.addActionListener(this);
		one=new Button("1");
		two=new Button("2");
		three=new Button("3");
		four=new Button("4");
		five=new Button("5");
		six=new Button("6");
		seven=new Button("7");
		eight=new Button("8");
		nine=new Button("9");
		zero=new Button("0");
		dec=new Button(".");
		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		mod=new Button("%");
		equal=new Button("=");
		clr=new Button("Clear");
		GridLayout gb=new GridLayout(5,4,10,4);
		setLayout(gb);		
  		
		bList[0]=(Button)add(one);
		bList[1]=(Button)add(two);
		bList[2]=(Button)add(three);
		bList[3]=(Button)add(four);
		bList[4]=(Button)add(five);
		bList[5]=(Button)add(six);
		bList[6]=(Button)add(seven);
		bList[7]=(Button)add(eight);
		bList[8]=(Button)add(nine);
		bList[9]=(Button)add(zero);
		bList[10]=(Button)add(dec);
		bList[11]=(Button)add(add);
		bList[12]=(Button)add(sub);
		bList[13]=(Button)add(mul);
		bList[14]=(Button)add(div);
		bList[15]=(Button)add(mod);	
		bList[16]=(Button)add(equal);
		bList[17]=(Button)add(clr);
		
		
		for(int i=0;i<18;i++)
		{
			bList[i].addActionListener(this);
		}
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
			String str=ae.getActionCommand();
			char ch=str.charAt(0);
			if ( Character.isDigit(ch))
			{	
				if(count==true)
				{
					if(again==true)
					{
						str2="";
					}
					String s=ae.getActionCommand();
					str2= str2+s;
					
				}
				space.setText(space.getText()+str);
			
			}
			else if(str.equals("+"))
			{
				again=false;
				count=true;
				a=Integer.parseInt(space.getText());
				operand="+";
				space.setText(space.getText()+operand);
			}
			else if(str.equals("-"))
			{	
				again=false;count=true;
				a=Integer.parseInt(space.getText());
				operand="-";
				space.setText(space.getText()+operand);
			}
			else if(str.equals("*"))
			{	count=true;again=false;
				a=Integer.parseInt(space.getText());
				operand="*";
				space.setText(space.getText()+operand);
			}
			else if(str.equals("/"))
			{	count=true;again=false;
				a=Integer.parseInt(space.getText());
				operand="/";
				space.setText(space.getText()+operand);
			}
			else if(str.equals("%"))
			{	count=true;again=false;
				a=Integer.parseInt(space.getText());
				operand="%";
				space.setText(space.getText()+operand);
			}
		
		
			else if(str.equals("="))	
			{
			
				again=true;
				b=Integer.parseInt(str2);
				str2="";
				if(operand.equals("+"))
				res=a+b;
				else if(operand.equals("-"))
				res=a-b;
				else if(operand.equals("*"))
				res=a*b;
				else if(operand.equals("/"))
				res=a/b;
				else 
				res=a%b;
				space.setText(""+Integer.toString(res));
				
			}
			else if(str.equals("Clear"))
			{
				a=0;b=0;str="";operand="";
				res=0;count=false;str2="";
				space.setText("");
			}			
		
	}
	
	public void paint(Graphics g)
	{
		//g.drawString(str2,40,200);
	}
}
