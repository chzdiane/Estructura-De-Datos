/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

/**
 *
 * @author Dianella
 */
public class Validate {
    
    public boolean checkParanthesisBalanced(String exp) {
        LinkedStack validateStack = new LinkedStack();
        char[] arrayString = exp.toCharArray();
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == '{') {
                validateStack.push('{');
                if (validateStack.getTop().getNextNode() != null && (char) validateStack.getTop().getNextNode().getData() == '[') {
                    return false;
                } else if (validateStack.getTop().getNextNode() != null && (char) validateStack.getTop().getNextNode().getData() == '(') {
                    return false;
                }
            } else if (arrayString[i] == '}') {
                if (validateStack.empty()) {
                    return false;
                } else if ((char) validateStack.pop() != '{') {
                    return false;
                }
            } else if (arrayString[i] == '[') {
                validateStack.push('[');
                if (validateStack.getTop().getNextNode() != null && (char) validateStack.getTop().getNextNode().getData() == '(') {
                    return false;
                }
            } else if (arrayString[i] == ']') {
                if (validateStack.empty()) {
                    return false;
                } else {
                    if ((char) validateStack.pop() != '[') {
                        return false;
                    }
                }
            } else if (arrayString[i] == '(') {
                validateStack.push('(');
            } else if (arrayString[i] == ')') {
                if (validateStack.empty()) {
                    return false;
                } else {
                    if ((char) validateStack.pop() != '(') {
                        return false;
                    }
                }
            }
        }
        return validateStack.empty();
    }
    
}
