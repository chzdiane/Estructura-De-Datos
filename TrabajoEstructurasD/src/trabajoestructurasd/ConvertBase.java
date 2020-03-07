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
public class ConvertBase {
    public String toBinary(int n) {
        LinkedStack bin = new LinkedStack();
        
        String binary = "Número en binario ";

        while (n > 0) {
            bin.push(n % 2);
            n /= 2;
        }
        while (!bin.empty()) {
            try {
                binary += bin.pop();
            } catch (Exception e) {
                binary = "Error interno";
            }
        }
        return binary;
    }

    public String toOctal(int n) {
        LinkedStack oc = new LinkedStack();
        String octal = "Número en octal: ";

        while (n > 0) {
            oc.push(n % 8);
            n /= 8;
        }
        while (!oc.empty()) {
            try {
                octal += oc.pop();
            } catch (Exception e) {
                octal = "Error interno";
            }
        }
        return octal;
    }

    public String toHexadecimal(long n) {
        LinkedStack hex = new LinkedStack();
        String hexadecimal = "Número en hexadecimal: ";
        while (n > 0) {
            if (n % 16 == 10) {
                hex.push('A');
            } else if (n % 16 == 11) {
                hex.push('B');
            } else if (n % 16 == 12) {
                hex.push('C');
            } else if (n % 16 == 13) {
                hex.push('D');
            } else if (n % 16 == 14) {
                hex.push('E');
            } else if (n % 16 == 15) {
                hex.push('F');
            } else {
                hex.push(n % 16);
            }
            n /= 16;
        }
        while (!hex.empty()) {
            try {
                hexadecimal += hex.pop();
            } catch (Exception e) {
                hexadecimal = "Error interno";
            }
        }
        return hexadecimal;
    }

    public String toDecimal(int n) {
        String decimal = "Número en decimal: ";
        decimal += n;
        return decimal;
    }

    public String toBase(String base, int n) throws Exception {
        String converted = "";
        if (base == "10") {
            converted = toDecimal(n);
        } else if (base == "2") {
            converted = toBinary(n);
        } else if (base == "8") {
            converted = toOctal(n);
        } else if (base == "16")  {
            converted = toHexadecimal(n);
        } else {
            throw new Exception("Ingrese una base válida por favor (2, 8, 16)");
        }
        return converted;
    }
}
