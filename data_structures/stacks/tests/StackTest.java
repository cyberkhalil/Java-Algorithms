package data_structures.stacks.tests;

import data_structures.stacks.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author khalil2535
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> Strings = new Stack<>(10);
        String name = JOptionPane.showInputDialog("Enter Your name to flop : ");
        while (!name.isEmpty()) {
            Strings.push(name.subSequence(0, 1) + "");
            name = (String) name.subSequence(1, name.length());
        }
        System.out.println(Strings.toString());
        name = "";
        while (!Strings.isEmpty()) {
            name += Strings.pop().toLowerCase();
        }
        JOptionPane.showMessageDialog(null, "Flopped name : " + name);
    }
}
