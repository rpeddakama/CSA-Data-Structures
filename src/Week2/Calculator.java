package src.Week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import src.Blueprint;

public class Calculator extends Blueprint {

    // Key instance variables
    private String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result;

    // Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
        OPERATORS.put("^", 2);
        OPERATORS.put("SQRT", 2);
        OPERATORS.put("PYTHAG", 2);
    }

    private final HashMap<String, Integer> NUMOPERANDS = new HashMap<>();
    {
        // Map<"token", precedence>
        NUMOPERANDS.put("*", 2);
        NUMOPERANDS.put("/", 2);
        NUMOPERANDS.put("%", 2);
        NUMOPERANDS.put("+", 2);
        NUMOPERANDS.put("-", 2);
        NUMOPERANDS.put("^", 2);
        NUMOPERANDS.put("SQRT", 1);
        NUMOPERANDS.put("PYTHAG", 2);
    }

    // Helper definition for supported operators
    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }

    public Calculator(String optionTitle) {
        super(optionTitle);
    }

    // Term Tokenizer takes original expression and converts it to ArrayList of
    // tokens
    private void termTokenizer() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0; // term split starting index
        StringBuilder multiCharTerm = new StringBuilder(); // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if (isOperator(c.toString()) || isSeperator(c.toString())) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }

        // System.out.println("TERM TOKENIZER END");
    }

    // Takes tokens and converts to Reverse Polish Notation (RPN), this is one where
    // the operator follows its operands.
    private void tokensToReversePolishNotation() {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack<String> tokenStack = new Stack<String>();
        for (String token : tokens) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.size() > 0 && !tokenStack.peek().equals("(")) {
                        reverse_polish.add((String) tokenStack.pop());
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                case "SQRT":
                case "PYTHAG":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    while (tokenStack.size() > 0 && isOperator((String) tokenStack.peek())) {
                        if (isPrecedent(token, (String) tokenStack.peek())) {
                            reverse_polish.add((String) tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default: // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
            }
        }
        // Empty remaining tokens
        while (tokenStack.size() > 0) {
            reverse_polish.add((String) tokenStack.pop());
        }

        // System.out.println("TOKENS TO RPN");
    }

    // Takes RPN and produces a final result
    private void rpnToResult() {
        // Stack used to hold calculation while process RPN
        Stack<Object> calculation = new Stack<Object>();
        double a = 0.0, b = 0.0;

        for (int i = 0; i < reverse_polish.size(); i++) {
            if (!OPERATORS.containsKey(reverse_polish.get(i))) {
                calculation.push(Double.parseDouble(reverse_polish.get(i)));
            } else {
                // assume 2 operands otherwise
                a = (Double) (calculation.pop());
                if (!reverse_polish.get(i).equals("SQRT"))
                    b = (Double) (calculation.pop());
            }
            switch (reverse_polish.get(i)) {
                case "+":
                    calculation.push((a + b));
                    break;
                case "-":
                    calculation.push((b - a));
                    break;
                case "*":
                    calculation.push((a * b));
                    break;
                case "/":
                    calculation.push((b / a));
                    break;
                case "%":
                    calculation.push((b % a));
                    break;
                case "^":
                    calculation.push((Math.pow(b, a)));
                    break;
                case "SQRT":
                    calculation.push((Math.sqrt(a)));
                    break;
                case "PYTHAG":
                    calculation.push(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
            }
        }
        // Pop final result and set as final result for expression
        this.result = (Double) calculation.pop();
    }

    // Test if token is an operator
    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test if token is an separator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Compare precedence of operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0);
    }

    public void run() {
        String[] trials = { "100 + 200  * 3", "PYTHAG(3 (2+2))", "SQRT(4 + 12) + 5", "2 ^ 2", "(100 + 200)  * 3",
                "100.2 - 99.3",
                "300 % 200" };
        // "300/200", "300 * 200", "200 % 300 + 5 + 300 / 200 + 1 * 100", "200 % (300 +
        // 5 + 300) / 200 + 1 * 100",
        // "200%(300+5+300)/200+1*100" };
        for (String s : trials) {
            // initial string
            this.expression = s;

            // parse expression into terms
            this.termTokenizer();

            // place terms into reverse polish notation
            this.tokensToReversePolishNotation();

            // calculate reverse polish notation
            this.rpnToResult();

            System.out.println(toString());
        }
    }

    // Print the expression, terms, and result
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " + this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result) + "\n");
    }

}
