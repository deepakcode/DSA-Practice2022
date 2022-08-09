package com.practice.dp.mcm;

/**
 * char symbols[] = "TTFT".toCharArray();
 * char operators[] = "|&^".toCharArray();
 * int n = symbols.length;
 * <p>
 * // There are 4 ways
 * // ((T|T)&(F^T)), (T|(T&(F^T))),
 * // (((T|T)&F)^T) and (T|((T&F)^T))
 * System.out.println(
 * countParenth(symbols, operators, n));
 */
public class EvaluateExpToTrue {

    public static void main(String[] args) {
        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < symbols.length; i++) {
            sb.append(symbols[i]);
            if (j < operators.length)
                sb.append(operators[j]);
            j++;
        }
        char[] expression = sb.toString().toCharArray();
        int n = expression.length;
        // T|T&F^T
        int r = expressionEvaluate(expression, 0, n - 1, true);
        System.out.println("Result : " + r);
    }

    private static int expressionEvaluate(char[] expression, int i, int j, boolean isTrue) {

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue)
                return expression[i] == 'T' ? 1 : 0;
            else
                return expression[i] == 'F' ? 1 : 0;
        }

        int min = Integer.MAX_VALUE - 1;

        int temp_ans = 0;

        int leftTrue, rightTrue, leftFalse, rightFalse;


        for (int k = i + 1; k <= j - 1; k = k + 2) {

            leftTrue = expressionEvaluate(expression, i, k-1, true);
            leftFalse = expressionEvaluate(expression, i, k-1, false);

            rightTrue = expressionEvaluate(expression, k + 1, j, true);
            rightFalse = expressionEvaluate(expression, k + 1, j, false);

            if (k == '|') {

                if (isTrue) {
                    temp_ans = temp_ans
                            +leftTrue * rightTrue
                            +leftFalse*rightTrue
                            +leftTrue*rightFalse;
                } else {
                    temp_ans = 1 +leftFalse*rightFalse;
                }
                //1|1 =1
                //0|1 =1
                //1|0 =1
                //0|0 =0
            }

            if (k == '&') {
                if(isTrue){
                    temp_ans = temp_ans
                            +leftTrue*rightTrue;

                }else{
                    temp_ans = temp_ans +
                            +leftFalse*rightTrue
                            +leftTrue*rightFalse
                            +leftFalse*rightFalse;
                }
                //1|1 =1
                //0|1 =0
                //1|0 =0
                //0|0 =0
            }

            if (k == '^') {
                if(isTrue){
                    temp_ans = temp_ans
                            +leftFalse*rightTrue
                            +leftTrue*rightFalse;
                }else {
                    temp_ans = temp_ans
                            +leftTrue*rightTrue
                            +leftFalse*rightFalse;
                }
                //1|1 =0
                //0|1 =1
                //1|0 =1
                //0|0 =0
            }
        }
        return temp_ans; //TODO
    }
}
