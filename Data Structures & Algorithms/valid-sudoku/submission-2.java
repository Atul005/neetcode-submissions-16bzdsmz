class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateRow(board) && validateCol(board) && validateSquare(board);
    }

    public boolean validateRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }

                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    public boolean validateCol(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[j][i];
                if (ch == '.') {
                    continue;
                }

                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    public boolean validateSquare(char[][] board) {
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[i].length; j = j + 3) {
                Set<Character> set = new HashSet<>();
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        char ch = board[r][c];

                        if (ch == '.') {
                            continue;
                        }

                        if (set.contains(ch)) {
                            return false;
                        } else {
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}
