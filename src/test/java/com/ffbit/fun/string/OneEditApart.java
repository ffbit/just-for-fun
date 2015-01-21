package com.ffbit.fun.string;

/**
 * http://www.glassdoor.com/GD/Interview/Facebook-Interview-Questions-E40772.htm?filter.jobTitleExact=Software+Engineer%2C+Android#InterviewReview_4341163
 * <p/>
 * Implement method oneEditApart that return boolean:
 * true, if using one operations (insert or remove or replace) we can modify one string to get another.
 * False otherwise.
 * <p/>
 * // Signature:
 * boolean oneEditApart(String s1, String s2)
 * //Allowing operations
 * insert
 * remove
 * replace
 * <p/>
 * Example:
 * <p/>
 * oea("cat","cut")=>true // replace "u" -> "a"
 * oea("cat","cuts")=>false // no operations
 * oea("ca","ca")=>false // no operations
 * oea("cats","cat")=>true // remove "s"
 * oea("cat","at")=>true // insert "c"
 * oea("cat","cbat")=>true // remove "b"
 */
public class OneEditApart {

    public boolean oneEditApart(String a, String b) {
        return distance(a, b) == 1;
    }

    private int distance(String a, String b) {
        if (a.isEmpty()) {
            return b.length();
        } else if (b.isEmpty()) {
            return a.length();
        }

        int[][] matrix = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            matrix[i][0] = i;
        }

        for (int i = 0; i <= b.length(); i++) {
            matrix[0][i] = i;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    int substitution = matrix[i - 1][j - 1] + 1;
                    int deletion = matrix[i - 1][j] + 1;
                    int insertion = matrix[i][j - 1] + 1;

                    matrix[i][j] = Math.min(substitution,
                            Math.min(deletion, insertion));
                }
            }

        }

        return matrix[a.length()][b.length()];
    }

}
