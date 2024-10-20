class Solution {
   private int index = 0; 

    public boolean parseBoolExpr(String expression) {
        index = 0; 
        return evaluate(expression); 
    }

    private boolean evaluate(String expression) {
        char currentChar = expression.charAt(index++); 
        
        if (currentChar == 't') {
            return true; 
        }
        if (currentChar == 'f') {
            return false; 
        }
        if (currentChar == '!') {
            index++; 
            boolean result = !evaluate(expression); 
            index++; 
            return result; 
        }
        if (currentChar == '&') {
            index++; 
            boolean result = true; 
            while (expression.charAt(index) != ')') {
                result &= evaluate(expression); 
                if (expression.charAt(index) == ',') {
                    index++; 
                }
            }
            index++; 
            return result; 
        }
        if (currentChar == '|') {
            index++; 
            boolean result = false; 
            while (expression.charAt(index) != ')') {
                result |= evaluate(expression); 
                if (expression.charAt(index) == ',') {
                    index++; 
                }
            }
            index++; 
            return result; 
        }
        
        return false;
    }

}