package Tree;

import Expr.Postfix;
import Expr.Expression;
import java.util.Stack;

public class ExpressionTree extends Tree<String> {
    
    /**
     * Constructor that builds an expression tree from a Postfix object
     * @param postfix The Postfix object containing a valid postfix expression
     */
    public ExpressionTree(Postfix postfix) {
        super();
        this.root = buildExpressionTree(postfix);
    }
    
    /**
     * Private method to construct the expression tree from postfix expression
     * Uses a stack to build the tree bottom-up
     * @param postfix The Postfix object
     * @return The root of the constructed expression tree
     */
    private TreeCell<String> buildExpressionTree(Postfix postfix) {
        Stack<TreeCell<String>> stack = new Stack<>();
        String postfixExpr = postfix.getPostfixExpr();
        String[] tokens = postfixExpr.split("\\s+");
        
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            
            // If token is an operator
            if (isOperator(token)) {
                // Pop two operands from stack
                if (stack.size() < 2) {
                    throw new IllegalStateException("Invalid postfix expression: not enough operands");
                }
                
                TreeCell<String> right = stack.pop();
                TreeCell<String> left = stack.pop();
                
                // Create new node with operator as datum and operands as children
                TreeCell<String> operatorNode = new TreeCell<>(token, left, right);
                stack.push(operatorNode);
            }
            // If token is an operand (number)
            else if (isNumber(token)) {
                // Create leaf node with the number
                TreeCell<String> operandNode = new TreeCell<>(token, null, null);
                stack.push(operandNode);
            }
        }
        
        // The stack should contain exactly one element - the root
        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid postfix expression: incorrect number of operators/operands");
        }
        
        return stack.pop();
    }
    
    /**
     * Check if token is an operator
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    /**
     * Check if token is a number
     */
    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Evaluates the expression tree recursively
     * @return The result of the evaluation
     */
    public int evaluate() {
        if (root == null) {
            throw new IllegalStateException("Expression tree is empty");
        }
        return evaluateNode(root);
    }
    
    /**
     * Recursively evaluate a node in the expression tree
     * @param node The current node to evaluate
     * @return The result of evaluating this subtree
     */
    private int evaluateNode(TreeCell<String> node) {
        if (node == null) {
            throw new IllegalStateException("Null node encountered");
        }
        
        // If leaf node, return the number
        if (node.getLeft() == null && node.getRight() == null) {
            return Integer.parseInt(node.getDatum());
        }
        
        // Recursively evaluate left and right subtrees
        int leftValue = evaluateNode(node.getLeft());
        int rightValue = evaluateNode(node.getRight());
        
        // Apply the operator at this node
        return applyOperation(leftValue, rightValue, node.getDatum());
    }
    
    /**
     * Apply operation to two operands
     */
    private int applyOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        try {
            // Test cases
            String[] testExpressions = {
                "5 + 3",
                "10 - 2 * 3",
                "(5 + 3) * 2",
                "100 / (5 - 3)",
                "2 + 3 * 4 - 5",
                "(8 + 9 * (4 + 5 * 7 + 6)) + 3 * 5 + 4"
            };
            
            System.out.println("Expression Tree Test:\n");
            
            for (String test : testExpressions) {
                try {
                    Expression expr = new Expression(test);
                    Postfix postfix = new Postfix(expr);
                    ExpressionTree tree = new ExpressionTree(postfix);
                    
                    System.out.println("Original Infix: " + test);
                    System.out.println("Postfix: " + postfix.getPostfixExpr());
                    tree.printTree();
                    System.out.println("Evaluation: " + tree.evaluate());
                    System.out.println();
                    
                } catch (Exception e) {
                    System.out.println("Error with expression '" + test + "': " + e.getMessage());
                    System.out.println();
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}