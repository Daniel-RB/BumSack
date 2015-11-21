import java.awt.*;
import java.awt.event.*;

public class Calculator
{
  private static class NumericHandler implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      double secondOperand;
      String whichButton;
      secondOperand = Double.valueOf(inputField.getText()).doubleValue();
      whichButton=event.getActionCommand();
      if(whichButton.equals("add"))
        result = result + secondOperand;
      else if(whichButton.equals("multiplication"))
          result = result * secondOperand;
      else if(whichButton.equals("boob"))
    	  result = 8008;
      else
        result = result- secondOperand;
      register.setText("" + result);
      inputField.setText("");
    }
  }
  
  private static class ClearHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      result = 0.0;
      register.setText("0.0");
      inputField.setText("");
    }
  }
  
  private static TextField inputField;
  private static Label register;
  private static Frame calcFrame;
  private static double result;
  
  public static void main(String[] args)
  {
    NumericHandler operation;
    ClearHandler clearOperation;
    Label resultLabel;
    Label entryLabel;
    Button add;
    Button subtract;
    Button multiplication;
    Button boob;
    Button clear;
    
    operation = new NumericHandler();
    clearOperation = new ClearHandler();
    result = 0.0;
    
    calcFrame = new Frame();
    calcFrame.setLayout(new GridLayout(4,2));
    resultLabel = new Label("Result: ");
    register = new Label("0.0", Label.RIGHT);
    entryLabel = new Label("Enter #: ");
    inputField = new TextField("", 20);
    
    add = new Button("+");
    subtract = new Button("-");
    multiplication = new Button("*");
    boob = new Button("(.)(.)");
    clear = new Button ("Clear");
    
    add.setActionCommand("add");
    subtract.setActionCommand("subtract");
    multiplication.setActionCommand("multiplication");
    boob.setActionCommand("boob");
    clear.setActionCommand("clear");
    
    add.addActionListener(operation);
    subtract.addActionListener(operation);
    multiplication.addActionListener(operation);
    boob.addActionListener(operation);
    clear.addActionListener(clearOperation);
    
    calcFrame.add(resultLabel);
    calcFrame.add(register);
    calcFrame.add(entryLabel);
    calcFrame.add(inputField);
    calcFrame.add(add);
    calcFrame.add(subtract);
    calcFrame.add(multiplication);
    calcFrame.add(boob);
    calcFrame.add(clear);
    calcFrame.pack();
    calcFrame.setVisible(true);
    calcFrame.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent event)
        {
          calcFrame.dispose();
          System.exit(0);
        }
      });
  }
}
